package com.simplegame.server.bus.client.io.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.simplegame.core.data.accessor.cache.manager.CacheManager;
import com.simplegame.core.event.IEventService;
import com.simplegame.server.bus.client.io.event.publish.RoleLoginEvent;
import com.simplegame.server.bus.client.io.service.IIoService;
import com.simplegame.server.bus.share.service.IRoleStateService;

@Component
public class IoServiceImpl implements IIoService {
    
    private Logger LOG = LoggerFactory.getLogger(getClass());
    
    private boolean usecache = true;

    @Resource
    private CacheManager roleCacheManager;

    @Resource
    private IRoleStateService roleStateService;

    @Resource
    private IEventService eventService;

    public IoServiceImpl() {
    }

    public void roleIn(String roleId, String paramString2) {
        if (this.usecache) {
            this.roleCacheManager.activateRoleCache(roleId);
        }
        
        this.roleStateService.change2online(roleId);
        
        try {
            this.eventService.publish(new RoleLoginEvent(roleId, paramString2));
        } catch (Exception e) {
            LOG.error("roleIn exception roleId: {}", roleId, e);
        }
    }

    public void syncRoleIn(String roleId, Object paramObject) {
    }

    public void roleOut(String roleId) {
        if (this.usecache) {
            this.roleCacheManager.freezeRoleCache(roleId);
        }
        this.roleStateService.change2offline(roleId);
    }

    public void roleOutOnServerClose(String roleId) {
        roleOut(roleId);
    }

    public void syncRoleOut(String roleId) {
        roleOut(roleId);
    }
}