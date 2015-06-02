package com.simplegame.server.bus.id.service;

import com.simplegame.server.bus.id.entity.IdGen;

/**
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月25日 下午9:51:20 
 *
 */
public interface IIdGenService {

	public IdGen getIdGenByModule(String moduleName, String prefix);
	
	public String getServerId();
	
}
