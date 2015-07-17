package com.simplegame.server.stage.event.subscribe;

import org.springframework.stereotype.Component;

import com.simplegame.core.event.IEventHandler;

@Component
public class StageRoleLogoutHandler implements IEventHandler {
    
//    @Autowired
//    private IAutoFightService autoFightService;

    public void handle(Object paramObject1, Object paramObject2) {
//        this.autoFightService.offlineHandler((String) paramObject1);
    }

    public String getEventType() {
        return "role_logout";
    }
}