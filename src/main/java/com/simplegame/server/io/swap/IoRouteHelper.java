package com.simplegame.server.io.swap;

import com.simplegame.protocol.message.Message;
import com.simplegame.server.executor.Route;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月7日 下午5:46:44
 * 
 */

public class IoRouteHelper {

	public static final String IO_ALL_GROUP = "IO_ALL";
	public static final String IO_BUS_GROUP = "IO_BUS";
	public static final String IO_STAGE_GROUP = "IO_STAGE";

	public IoRouteHelper() {
		
	}
	
	public Route getRoute(Message message, int routeType) {
		Route route = null;
		
		switch(routeType) {
		case 1: 
			route = new Route(IO_ALL_GROUP);
			route.setData(message.getRoleId());
			break;
		case 2:
			route = new Route(IO_BUS_GROUP);
			route.setData(message.getRoleId());
			break;
		case 3:
			route = new Route(IO_STAGE_GROUP);
			route.setData(message.getStageId());
			break;
		default:
			route = new Route(IO_ALL_GROUP);
			route.setData(message.getRoleId());
			break;
		}
		return route;
	}
}
