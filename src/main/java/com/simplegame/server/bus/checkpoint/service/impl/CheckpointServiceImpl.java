package com.simplegame.server.bus.checkpoint.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.server.bus.checkpoint.configure.ICheckpointConfigService;
import com.simplegame.server.bus.checkpoint.configure.impl.CheckpointConfig;
import com.simplegame.server.bus.checkpoint.service.ICheckpointService;
import com.simplegame.server.bus.map.configure.IMapConfigService;
import com.simplegame.server.bus.map.configure.impl.MapConfig;
import com.simplegame.server.bus.role.export.IRoleExportService;
import com.simplegame.server.bus.role.export.RoleWrapper;
import com.simplegame.server.bus.stagecontroll.command.StageControllCommands;
import com.simplegame.server.stage.model.stage.checkpoint.CheckpointStageCopy;
import com.simplegame.server.stage.model.stage.checkpoint.CheckpointStageCopyFactory;
import com.simplegame.server.stage.service.IStageService;
import com.simplegame.server.stage.swap.StageMsgQueue;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年8月31日 下午5:43:01
 *
 */
@Component
public class CheckpointServiceImpl implements ICheckpointService {

    @Resource
    private IStageService stageService;
    
    @Resource
    private IRoleExportService roleExportService;
    
    @Resource
    private ICheckpointConfigService checkpointConfigService;
    
    @Resource
    private IMapConfigService mapConfigService;
    
    @Override
    public void enterCopy(String roleId, String checkpointId, StageMsgQueue msgQueue) {
        RoleWrapper roleWrapper = this.roleExportService.getRole(roleId);
        
        //等级判断
        //if( roleWrapper.getLevel() < XXX Level )
        
        //各种判断是否能进入
        CheckpointConfig config = checkpointConfigService.loadById(checkpointId);
        
        Object[] additionalData = new Object[]{config.getId()};
        msgQueue.addStageControllMsg(roleId, StageControllCommands.INNER_APPLY_CHANGE_COPY, new Object[]{config.getMapId(), config.getInitial().getX(), config.getInitial().getY(), additionalData});
        
    }

    @Override
    public void createCheckpointCopy(String roleId, String stageId, String mapId, Object[] additionalData) {
        String checkpointId = (String)additionalData[0];
        
        MapConfig mapConfig = mapConfigService.load(mapId);
        CheckpointConfig checkpointConfig = checkpointConfigService.loadById(checkpointId);
        
        CheckpointStageCopy copy = CheckpointStageCopyFactory.create(stageId, checkpointConfig, mapConfig);
        
        stageService.addStageCopy(copy);
    }

}
