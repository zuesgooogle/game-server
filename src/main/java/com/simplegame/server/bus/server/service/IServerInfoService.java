package com.simplegame.server.bus.server.service;

import java.sql.Timestamp;
import java.util.List;

import com.simplegame.server.bus.server.entity.ServerInfo;

/**
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月23日 下午10:16:19
 * 
 */
public interface IServerInfoService {

	public void init();

	public Timestamp getServerStartTime();

	public Timestamp getServerHefuTime();

}
