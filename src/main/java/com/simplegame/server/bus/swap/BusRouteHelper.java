package com.simplegame.server.bus.swap;

import com.simplegame.core.message.Message;
import com.simplegame.server.executor.Route;
import com.simplegame.server.message.IRouteHelper;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年6月19日 下午6:18:36
 * 
 */

public class BusRouteHelper implements IRouteHelper {

    @Override
    public Route getRoute(Message message) {
        Route route = null;
        
        switch (message.getDest().getValue()) {
        case 1:
            route = new Route("bus_cache");
            route.setData(message.getRoleId());
            break;
        case 2:
            route = new Route("stage_control");
            route.setData(message.getRoleId());
            break;
        case 5:
            route = new Route("bus_init");
            route.setData(message.getRoleId());
            break;
        case 7:
            route = new Route("system");
            route.setData(message.getRoleId());
            break;
        }
        return route;
    }

}
