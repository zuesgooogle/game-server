package com.simplegame.server.stage.service.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.core.event.IEventService;
import com.simplegame.server.bus.map.configure.IMapConfigExportService;
import com.simplegame.server.bus.stagecontroll.command.StageControllCommands;
import com.simplegame.server.stage.event.publish.RoleEnterStageEvent;
import com.simplegame.server.stage.event.publish.RoleLeaveStageEvent;
import com.simplegame.server.stage.event.publish.StageCreateEvent;
import com.simplegame.server.stage.model.core.element.impl.state.OfflineState;
import com.simplegame.server.stage.model.core.stage.ElementType;
import com.simplegame.server.stage.model.core.stage.IStage;
import com.simplegame.server.stage.model.core.stage.Point;
import com.simplegame.server.stage.model.element.role.IRole;
import com.simplegame.server.stage.model.element.role.RoleFactory;
import com.simplegame.server.stage.model.stage.aoi.AoiStageFactory;
import com.simplegame.server.stage.service.IStageService;
import com.simplegame.server.stage.swap.StageMsgSender;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月17日 上午11:15:41
 *
 */
@Component
public class StageServiceImpl implements IStageService {

    @Resource
    private IMapConfigExportService mapConfigExportService;
    
    @Resource
    private IEventService eventService;
    
    @Resource
    private AoiStageFactory aoiStageFactory;
    
    @Resource
    private StageMsgSender stageMsgSender;
    
    @Resource
    private RoleFactory roleFactory;
    
    private ConcurrentMap<String, IStage> stageMap = new ConcurrentHashMap<String, IStage>();
    
    @Override
    public boolean checkAndCreateStage(String stageId, String mapId) {
        IStage stage = stageMap.get(stageId);
        if( null == stage ) {
            stage = aoiStageFactory.create(stageId, mapConfigExportService.load(mapId));
            stageMap.put(stageId, stage);
            
            //stage.getStageProduceManager().produceAll();
            
            eventService.publish(new StageCreateEvent(mapId, stageId));
            return true;
        }
        return false;
    }

    @Override
    public IStage getStage(String stageId) {
        return stageMap.get(stageId);
    }

    @Override
    public void removeStage(String stageId) {
        stageMap.remove(stageId);
    }
    
    @Override
    public boolean exist(String stageId) {
        return null != getStage(stageId);
    }

    @Override
    public boolean stageCanEnter(String stageId) {
        IStage stage = getStage(stageId);
        if( null == stage ) {
            return false;
        }
        return true;
    }

    @Override
    public Point getPosition(String stageId, String roleId) {
        IStage stage = getStage(stageId);
        IRole role = stage.getElement(roleId, ElementType.ROLE);
        
        if( null == role ) {
            return null;
        }
        return role.getPosition();
    }

    @Override
    public void roleLeaveStage(String stageId, String roleId) {
        IStage stage = getStage(stageId);
        if( null == stage ) {
            return;
        }
        
        IRole role = stage.getElement(roleId, ElementType.ROLE);
        if( null == role ) {
            return;
        }
        
        role.getEventManager().fireLogoutEvent();
        eventService.publish(new RoleLeaveStageEvent(roleId, stageId));
        
        role.getStateManager().add(new OfflineState());
        stage.leave(role);
    }

    @Override
    public void roleEnterStage(String stageId, String roleId, String mapId, int x, int y) {
        IStage stage = getStage(stageId);
        IRole role = stage.getElement(roleId, ElementType.ROLE);
        
        //已经在场景内
        if( role != null ) {
            stageMsgSender.sned2One(StageControllCommands.CHANGE_STAGE, roleId, stageId, new Object[]{1, stageId, mapId});
            return;
        }
        
        //填充，初始化 role 数据
        role = roleFactory.create(roleId, stage);
        stageMsgSender.sned2One(StageControllCommands.CHANGE_STAGE, roleId, stageId, new Object[]{1, stageId, mapId});
        
        stage.enter(role, x, y);
        eventService.publish(new RoleEnterStageEvent(stageId, mapId, roleId));
        
        //TODO add born buffer
        
        role.getEventManager().fireLoginEvent();
        
    }

}
