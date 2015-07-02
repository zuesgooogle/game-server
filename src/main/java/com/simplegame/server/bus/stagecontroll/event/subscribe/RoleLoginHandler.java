package com.simplegame.server.bus.stagecontroll.event.subscribe;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.core.event.IEventHandler;
import com.simplegame.server.bus.stagecontroll.command.StageControllCommands;
import com.simplegame.server.bus.swap.BusMsgSender;

@Component
public class RoleLoginHandler implements IEventHandler {
    
    @Resource
    private BusMsgSender busMsgSender;
    
    public void handle(Object paramObject1, Object paramObject2) {
        Object[] arrayOfObject = (Object[]) paramObject2;
        busMsgSender.send2BusInner(StageControllCommands.LOGIN, (String) arrayOfObject[0], arrayOfObject);
    }

    public String getEventType() {
        return "role_login";
    }
}