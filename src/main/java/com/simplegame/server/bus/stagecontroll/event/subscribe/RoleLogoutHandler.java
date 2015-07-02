package com.simplegame.server.bus.stagecontroll.event.subscribe;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.core.event.IEventHandler;
import com.simplegame.server.bus.stagecontroll.service.IStageControllService;

@Component
public class RoleLogoutHandler implements IEventHandler {
    
    @Resource
    private IStageControllService stageControllService;

    public void handle(Object paramObject1, Object paramObject2) {
        Object[] arrayOfObject = (Object[]) paramObject2;
        String str = (String) arrayOfObject[0];
        this.stageControllService.logout(str);
    }

    public String getEventType() {
        return "role_logout";
    }
}
