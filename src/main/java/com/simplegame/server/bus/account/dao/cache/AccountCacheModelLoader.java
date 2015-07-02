package com.simplegame.server.bus.account.dao.cache;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.core.data.accessor.cache.IEntityCache;
import com.simplegame.core.data.accessor.cache.IEntityCacheModelLoader;
import com.simplegame.server.bus.account.dao.IRoleAccountDao;
import com.simplegame.server.bus.account.dao.IUserAccountDao;
import com.simplegame.server.bus.account.entity.RoleAccount;
import com.simplegame.server.bus.account.entity.UserAccount;
import com.simplegame.server.bus.role.export.RoleWrapper;
import com.simplegame.server.bus.role.service.IUserRoleService;

@Component
public class AccountCacheModelLoader implements IEntityCacheModelLoader {
    
    @Resource
    private IRoleAccountDao roleAccountDao;
    
    @Resource
    private IUserAccountDao userAccountDao;
    
    @Resource
    private IUserRoleService userRoleService;

    public void load(String roleId, IEntityCache entityCache) {
        entityCache.addData(this.roleAccountDao.loadCacheFromDb(roleId), RoleAccount.class);
        
        RoleWrapper roleWrapper = this.userRoleService.getRole(roleId);
        entityCache.addData(this.userAccountDao.initUserAccount(roleWrapper.getUserId(), roleWrapper.getId(), roleWrapper.getServerId()), UserAccount.class);
    }
}