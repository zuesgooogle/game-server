package com.simplegame.server.bus.bag.event.subscribe;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.core.event.IEventHandler;
import com.simplegame.server.bus.bag.service.IBagService;
import com.simplegame.server.share.event.EventConstants;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年9月6日 下午5:00:57
 *
 */
@Component
public class BagRoleCreateEventHandler implements IEventHandler {

    @Resource
    private IBagService bagService;
    
    @Override
    public void handle(Object source, Object data) {
        Object[] array = (Object[]) data;
        
        String roleId = (String) array[1];
    
        bagService.createRoleBagSlot(roleId);
    }

    @Override
    public String getEventType() {
        return EventConstants.ROLE_CREATE;
    }

}
