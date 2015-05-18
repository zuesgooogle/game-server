package com.simplegame.server.public_.swap;

import com.simplegame.protocol.message.Message;
import com.simplegame.server.executor.Route;
import com.simplegame.server.message.IRouteHelper;
import com.simplegame.server.share.moduleinit.CommandGroup;

/**
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月9日 下午5:46:05 
 *
 */
public class PublicRouteHelper implements IRouteHelper {
	
	@Override
	public Route getRoute(Message message, int destType) {
		String command = message.getCommand();
		
		Route route = null;
		switch(destType) {
		case CommandGroup.DEST_TYPE_INOUT:
			Object[] data = (Object[])message.getData();
			
			route = new Route(CommandGroup.GROUP_LOGIN);
			route.setData((String)data[0]);
			break;
		case CommandGroup.DEST_TYPE_PUBLIC:
			route = new Route(CommandGroup.GROUP_PUBLIC);
			route.setData(command);
			break;
		case CommandGroup.DEST_TYPE_SYSTEM:
			route = new Route(CommandGroup.GROUP_SYSTEM);
			route.setData(message.getRoleId());
			break;
		}
		
		return route;
	}

}
