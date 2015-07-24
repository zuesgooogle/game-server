package com.simplegame.server.stage.swap;

import com.simplegame.protocol.message.Message;
import com.simplegame.protocol.message.Message.DestType;
import com.simplegame.server.executor.Route;
import com.simplegame.server.message.IRouteHelper;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月21日 下午3:10:31
 *
 */

public class StageRouteHelpler implements IRouteHelper {

    @Override
    public Route getRoute(Message message, int destType) {
        
        Route route = null;
        if( destType == DestType.INNER_SYSTEM.getValue() ) {
            route = new Route("system");
            route.setData(message.getStageId());
        } else {
            route = new Route("stage");
            route.setData(message.getStageId());
        }
        return route;
    }

}
