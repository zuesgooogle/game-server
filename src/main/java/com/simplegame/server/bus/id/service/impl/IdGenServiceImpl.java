package com.simplegame.server.bus.id.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simplegame.core.data.accessor.AccessType;
import com.simplegame.server.bus.id.dao.IIdGenDao;
import com.simplegame.server.bus.id.dao.impl.IdGenDaoImpl;
import com.simplegame.server.bus.id.entity.IdGen;
import com.simplegame.server.bus.id.service.IIdGenService;
import com.simplegame.server.utils.GameConfigureUtil;

/**
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月25日 下午9:54:34 
 *
 */
@Component
public class IdGenServiceImpl implements IIdGenService {

	private Map<String, ModuleVersion> moduleVersions = new HashMap<String, ModuleVersion>();

	@Resource
	private IIdGenDao idGenDao;

	public IdGenDaoImpl getDao() {
		return (IdGenDaoImpl) this.idGenDao;
	}
	
	@Override
	public IdGen getIdGenByModule(String moduleName, String prefix) {
		int version = getModuleVersion(moduleName);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("moduleName", moduleName);
		params.put("version", version);
		
		List<IdGen> list = getDao().getRecords(params, "", AccessType.getDirectDbType());
		
		return null;
	}

	@Override
	public String getServerId() {
		return GameConfigureUtil.getServerId();
	}
	
	private int getModuleVersion(String moduleName) {
		ModuleVersion moduleVersion = this.moduleVersions.get(moduleName);
		if (null == moduleVersion) {
			moduleVersion = new ModuleVersion();
			this.moduleVersions.put(moduleName, moduleVersion);
		}
		return moduleVersion.nextVersion();
	}

	
	private class ModuleVersion {
		private int value;

		private ModuleVersion() {
		}

		private int nextVersion() {
			return ++this.value;
		}
	}

}
