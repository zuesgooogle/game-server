package com.simplegame.server.bus.role.moduleinit;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.core.data.accessor.cache.IEntityCacheModelLoader;
import com.simplegame.server.bus.role.RoleModuleInfo;
import com.simplegame.server.bus.role.dao.cache.RoleCacheModelLoader;
import com.simplegame.server.bus.share.moduleinit.BusModuleInit;
import com.simplegame.server.share.moduleinit.Group;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年6月4日 下午4:50:39
 * 
 */
@Component
public class RoleModuleInit extends BusModuleInit {

	@Resource
	private RoleCacheModelLoader roleCacheModelLoader;
	
	protected IEntityCacheModelLoader[] getEntityCacheModelLoaders() {
		return new IEntityCacheModelLoader[] { this.roleCacheModelLoader };
	}
	
	@Override
	protected InCmd getInCmd() {
		return new InCmd(RoleModuleInfo.MODULE_NAME, Group.BUS.name, new String[] { "role_login_init", "12200", "12011", "19001", "ROLE_HALF_CHENMI",
				"ROLE_CHENMI" });

	}

	protected ModuleInfo getModuleInfo() {
		return new ModuleInfo(RoleModuleInfo.MODULE_NAME, RoleModuleInfo.MODULE_NAME_ALIAS);
	}
}
