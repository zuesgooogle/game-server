package com.simplegame.server.bus.stagecontroll.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.simplegame.core.container.DataContainer;
import com.simplegame.server.bus.map.configure.IMapConfigExportService;
import com.simplegame.server.bus.map.configure.export.impl.MapConfig;
import com.simplegame.server.bus.role.export.IRoleExportService;
import com.simplegame.server.bus.role.export.RoleWrapper;
import com.simplegame.server.bus.share.constants.BusShareConstant;
import com.simplegame.server.bus.stage.export.RoleStageWrapper;
import com.simplegame.server.bus.stagecontroll.RoleState;
import com.simplegame.server.bus.stagecontroll.command.StageControllCommands;
import com.simplegame.server.bus.stagecontroll.output.StageControllOutput;
import com.simplegame.server.bus.stagecontroll.position.AbsRolePosition;
import com.simplegame.server.bus.stagecontroll.position.RoleNormalPosition;
import com.simplegame.server.bus.stagecontroll.position.StageCopyPosition;
import com.simplegame.server.bus.stagecontroll.service.IStageControllService;
import com.simplegame.server.bus.swap.BusMsgSender;
import com.simplegame.server.stage.constants.StageCopyConstant;
import com.simplegame.server.stage.entity.RoleStage;
import com.simplegame.server.stage.model.core.stage.Point;
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
    
    @Resource
    private DataContainer dataContainer;
    
    @Resource
    private BusMsgSender busMsgSender;
    
    @Override
    public Object login(String roleId) {
        RoleStage roleStage = roleStageService.loadRoleStage(roleId);
        RoleStageWrapper roleStageWrapper = new RoleStageWrapper(roleStage);
        
        loginHandler(roleStageWrapper, roleId);
        RoleWrapper roleWrapper = this.roleExportService.getRole(roleId);
        
        int vipLevel = 1;
        Object[] chargeInfo = new Object[]{1000, 50};
        int gmState = 0;
        
        return StageControllOutput.login(roleWrapper, roleStageWrapper, vipLevel, chargeInfo, gmState);
    }

    /**
     * 初始化角色坐标，所在地图，场景
     * 
     * @param stageWrapper
     * @param roleId
     */
    private void loginHandler(RoleStageWrapper stageWrapper, String roleId) {
        RoleState roleState = new RoleState(roleId);
        /**
         * 缓存用户状态数据
         */
        dataContainer.putData(BusShareConstant.COMPONENT_NAME, roleId, roleState);
        
        RoleNormalPosition roleNormalPosition = new RoleNormalPosition(stageWrapper.getUserRoleId(), stageWrapper.getMapId(), stageWrapper.getMapX(), stageWrapper.getMapY());
        
        /**
         * 离线坐标
         * mapId, stageId, x, y
         */
        Object[] offlinePosition = stageWrapper.getCopyInfo();
        if( null != offlinePosition ) {
            MapConfig mapConfig = mapConfigExportService.load((String)offlinePosition[0]);
            
            String stageId = (String)offlinePosition[1];
            
            StageCopyPosition stagePosition = new StageCopyPosition(stageId, roleId, (String)offlinePosition[0], mapConfig.getMayType(), (Integer)offlinePosition[2], (Integer)offlinePosition[4]);
            stagePosition.setStageExist(true);
            if( stageService.stageCanEnter(stageId) ) {
                roleState.setReadyForPosition(stagePosition);
                roleState.setOfflineSavePosition(roleNormalPosition);
            } else {
                roleState.setReadyForPosition(roleNormalPosition);
            }
        } else {
            roleState.setReadyForPosition(roleNormalPosition);
        }
    }
    
    @Override
    public Object[] applyChangeMapAfterLogin(String roleId) {
        RoleState roleState = dataContainer.getData(BusShareConstant.COMPONENT_NAME, roleId);
        if( null == roleState ) {
            return null;
        }
        
        AbsRolePosition rolePosition = roleState.getReadyToPosition();
        return StageControllOutput.applyChangeMap(rolePosition.getMapId(), rolePosition.getX(), rolePosition.getY());
    }

    @Override
    public void changeMap(String roleId) {
        RoleState roleState = dataContainer.getData(BusShareConstant.COMPONENT_NAME, roleId);
        if( null == roleState ) {
            return ;
        }
        
        AbsRolePosition rolePosition = roleState.getCurPosition();
        if( null != rolePosition ) {
            //退出当前场景
            Point point = stageService.getPosition(rolePosition.getStageId(), roleId);
            if( null != point ) {
                rolePosition.setPosition(point.getX(), point.getY());
            }
            
            roleStageService.syncRoleStageData(roleId, rolePosition.getStageId());
            leaveStage(rolePosition);
        }
        
        
    }
    
    private void leaveStage(AbsRolePosition rolePosition) {
        busMsgSender.send2Stage(StageControllCommands.INNER_LEAVE_STAGE, rolePosition.getRoleId(), new Object[]{rolePosition.getStageId()});
    }
    
    private void enterStage(AbsRolePosition rolePosition) {
        busMsgSender.send2Stage(StageControllCommands.INNER_ENTER_STAGE, rolePosition.getRoleId(), rolePosition.enterPositionFormat());
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
            
            String stageId = StageCopyConstant.INIT_STAGE_PREFIX + mapConfig.getId();
            stageService.checkAndCreateStage(stageId, mapConfig.getId());
            
            LOG.info("server start. init stage: {}", stageId);
        }
    }

    @Override
    public AbsRolePosition getOfflineSaveMapPosition(String roleId) {
        RoleState roleState = dataContainer.getData(BusShareConstant.COMPONENT_NAME, roleId);
        if( null != roleState ) {
            return roleState.getOfflineSavePosition();
        }
        return null;
    }


}
