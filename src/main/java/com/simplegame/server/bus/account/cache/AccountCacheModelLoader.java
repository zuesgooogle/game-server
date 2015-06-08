package com.simplegame.server.bus.account.cache;

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

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月21日 下午6:19:47
 * 
 */
@Component
public class AccountCacheModelLoader implements IEntityCacheModelLoader {

	@Resource
	private IRoleAccountDao roleAccountDao;
	
	@Resource
	private IUserAccountDao userAccountDao;
	
	@Resource
	private IUserRoleService userRoleService;

	@Override
	public void load(String key, IEntityCache entityCache) {
		entityCache.addData(roleAccountDao.loadCacheFromDb(key), RoleAccount.class);
		
		RoleWrapper wrapper = userRoleService.getRole(key);
		entityCache.addData(userAccountDao.initUserAccount(wrapper.getUserId(), wrapper.getId(), wrapper.getServerId()), UserAccount.class);
	}

}
