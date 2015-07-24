package com.simplegame.server.stage.model.element.role;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.server.bus.role.export.IRoleExportService;
import com.simplegame.server.bus.role.export.RoleWrapper;
import com.simplegame.server.stage.model.core.element.impl.state.StateManager;
import com.simplegame.server.stage.model.core.stage.IStage;
import com.simplegame.server.stage.schedule.StageScheduleManager;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月21日 下午5:25:53
 *
 */
@Component
public class RoleFactory {

    @Resource
    private IRoleExportService roleExportService;
    
    public IRole create(String roleId, IStage stage) {
        RoleWrapper roleWrapper = roleExportService.getRole(roleId);
        
        RoleBusinessData businessData = new RoleBusinessData(roleWrapper);
        
        
        Role role = new Role(roleWrapper.getId(), roleWrapper.getName(), "1");
        role.setBusinessData(businessData);
        role.setStateManager(new StateManager());
        role.setScheduleManager(new StageScheduleManager());
        
        
        return role;
    }
    
}
