package com.simplegame.server.bus.stagecontroll.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.server.bus.role.export.IRoleExportService;
import com.simplegame.server.bus.role.export.RoleWrapper;
import com.simplegame.server.bus.stage.entity.RoleStage;
import com.simplegame.server.bus.stage.export.RoleStageWrapper;
import com.simplegame.server.bus.stagecontroll.output.StageControllOutput;
import com.simplegame.server.bus.stagecontroll.service.IStageControllService;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月2日 下午5:02:30
 *
 */
@Component
public class StageControllServiceImpl implements IStageControllService {

    @Resource
    private IRoleExportService roleExportService;
    
    @Override
    public Object login(String roleId) {
        RoleStage stage = new RoleStage();
        stage.setMapId("1");
        stage.setMapX(1);
        stage.setMapY(2);
        
        RoleStageWrapper roleStageWrapper = new RoleStageWrapper(stage);
        RoleWrapper roleWrapper = this.roleExportService.getRole(roleId);
        
        int vipLevel = 1;
        Object[] chargeInfo = new Object[]{1000, 50};
        int gmState = 0;
        
        return StageControllOutput.login(roleWrapper, roleStageWrapper, vipLevel, chargeInfo, gmState);
    }

    @Override
    public Object logout(String roleId) {
        // TODO Auto-generated method stub
        return null;
    }

}
