package com.simplegame.server.public_.nodecontrol.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.core.data.accessor.cache.manager.CacheManager;
import com.simplegame.core.event.IEventService;
import com.simplegame.core.sync.annotation.Sync;
import com.simplegame.server.bus.client.io.export.IClientIoExportService;
import com.simplegame.server.bus.role.service.IUserRoleService;
import com.simplegame.server.public_.nodecontrol.event.publish.RoleLogoutEvent;
import com.simplegame.server.public_.nodecontrol.service.INodeControlService;
import com.simplegame.server.public_.share.constants.PublicNodeConstants;
import com.simplegame.server.public_.share.service.IPublicRoleStateService;

/**
 * @Author zeusgooogle@gmail.com
 * @sine 2015年6月11日 下午4:01:03
 * 
 */
@Component
public class NodeControlServiceImpl implements INodeControlService {

	private boolean usecache = true;
	
	@Resource
	private IPublicRoleStateService roleStateService;
	
	@Resource
	private IEventService eventService;
	
	@Resource
	private IUserRoleService userRoleService;
	
	@Resource
	private CacheManager publicCacheManager;
	
	@Resource
	private IClientIoExportService clientIoExportService;

	@Override
	public void change2online(String userRoleId) {
		roleStateService.change2PublicOnline(userRoleId);
	}

	@Override
	public void change2offline(String userRoleId) {
		roleStateService.change2PublicOffline(userRoleId);
	}

	@Override
	public void nodeLogin(String roleId, String ip) {
		if( usecache ) {
			publicCacheManager.activateRoleCache(roleId);
		}
		
		//roleIn
		clientIoExportService.roleIn(roleId, ip);
	}

	@Override
	public void nodeExit(String roleId, String ip) {
		if( roleStateService.isPublicOnline(roleId) ) {
			long onlineTime = userRoleService.getRole(roleId).getOnlineTime();
			eventService.publish(new RoleLogoutEvent(roleId, ip, onlineTime));
		}
		
		if( usecache ) {
			publicCacheManager.freezeRoleCache(roleId);
		}
		
		//roleOut
		clientIoExportService.roleOut(roleId);
	}

	@Sync(component = PublicNodeConstants.COMPONENT_NAME, indexes = { 0 })
	@Override
	public void nodeExitOnServerClose(String userRoleId) {
		nodeExit(userRoleId, null);
	}

}
