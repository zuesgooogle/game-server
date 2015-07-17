package com.simplegame.server.bus.stagecontroll.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.simplegame.server.bus.map.configure.IMapConfigExportService;
import com.simplegame.server.bus.map.configure.export.impl.MapConfig;
import com.simplegame.server.bus.role.export.IRoleExportService;
import com.simplegame.server.bus.role.export.RoleWrapper;
import com.simplegame.server.bus.stage.export.RoleStageWrapper;
import com.simplegame.server.bus.stagecontroll.output.StageControllOutput;
import com.simplegame.server.bus.stagecontroll.service.IStageControllService;
import com.simplegame.server.stage.entity.RoleStage;
import com.simplegame.server.stage.service.IRoleStageService;
import com.simplegame.server.stage.service.IStageService;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月2日 下午5:02:30
 *
 */
@Component
public class StageControllServiceImpl implements IStageControllService {

    private Logger LOG = LoggerFactory.getLogger(getClass());
    
    @Resource
    private IRoleExportService roleExportService;

    @Resource
    private IMapConfigExportService mapConfigExportService;
    
    @Resource
    private IStageService stageService;
    
    @Resource
    private IRoleStageService roleStageService;
    
    @Override
    public Object login(String roleId) {
        RoleStage roleStage = roleStageService.loadRoleStage(roleId);
        RoleStageWrapper roleStageWrapper = new RoleStageWrapper(roleStage);
        
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

    @Override
    public boolean isOnline(String roleId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void serverStartInitStage() {
        List<MapConfig> list = mapConfigExportService.loadAll();
        for (MapConfig mapConfig : list) {
            String stageId = "init-stage-" + mapConfig.getId();
            stageService.checkAndCreateStage(stageId, mapConfig.getId());
            
            LOG.info("server start. init stage: {}", stageId);
        }
    }

}
