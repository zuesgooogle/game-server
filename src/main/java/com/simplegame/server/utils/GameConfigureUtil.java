package com.simplegame.server.utils;

import com.simplegame.core.utils.ConfigureUtil;

/**
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月24日 下午9:51:57 
 *
 */
public class GameConfigureUtil {

	public static final String SERVER_INFO = "config/server-info.properties";
	
	
	public static String getServerId() {
		return ConfigureUtil.getProp(SERVER_INFO, "serverId");
	}
	
	public static String getServerPrefixRolename () {
		return ConfigureUtil.getProp(SERVER_INFO, "serverPrefixRolename");
	}
}
