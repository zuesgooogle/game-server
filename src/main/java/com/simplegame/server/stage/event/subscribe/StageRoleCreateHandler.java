package com.simplegame.server.stage.event.subscribe;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.core.event.IEventHandler;
import com.simplegame.server.stage.service.IRoleStageService;

@Component
public class StageRoleCreateHandler implements IEventHandler {
    
    @Resource
    private IRoleStageService roleService;

    public void handle(Object source, Object data) {
        Object[] array = (Object[]) data;
        
        String roleId = (String) array[1];
        int level = ((Integer) array[2]).intValue();
        this.roleService.createRoleStage(roleId, level);
    }

    public String getEventType() {
        return "role_create";
    }
}