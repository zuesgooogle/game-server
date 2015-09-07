package com.simplegame.server.stage.event.subscribe;

import org.springframework.stereotype.Component;

import com.simplegame.core.event.IEventHandler;
import com.simplegame.server.share.event.EventConstants;

@Component
public class StageRoleLogoutHandler implements IEventHandler {
    
//    @Autowired
//    private IAutoFightService autoFightService;

    @Override
    public void handle(Object source, Object data) {
//        this.autoFightService.offlineHandler((String) paramObject1);
    }

    @Override
    public String getEventType() {
        return EventConstants.ROLE_LOGOUT;
    }
}