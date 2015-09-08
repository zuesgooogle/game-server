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
import com.simplegame.server.bus.stagecontroll.position.RoleLocation;
import com.simplegame.server.bus.stagecontroll.service.IStageControllService;
import com.simplegame.server.stage.command.StageCommands;
import com.simplegame.server.stage.model.core.element.impl.state.StateType;
import com.simplegame.server.stage.model.core.stage.IStage;
import com.simplegame.server.stage.model.element.role.IRole;
import com.simplegame.server.stage.model.stage.checkpoint.CheckpointStageCopy;
import com.simplegame.server.stage.model.stage.checkpoint.CheckpointStageCopyFactory;
import com.simplegame.server.stage.service.IStageService;
import com.simplegame.server.stage.swap.StageMsgQueue;


/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年8月31日 下午5:43:01
 * 
 */
@Component
public class CheckpointServiceImpl implements ICheckpointService {

    @Resource
    private IStageService stageService;

    @Resource
    private IStageControllService stageControllService; 
    
    @Resource
    private IRoleExportService roleExportService;

    @Resource
    private ICheckpointConfigService checkpointConfigService;

    @Resource
    private IMapConfigService mapConfigService;

    @Override
    public void enterCopy(String roleId, String checkpointId, StageMsgQueue msgQueue) {
        RoleWrapper roleWrapper = this.roleExportService.getRole(roleId);

        // 等级判断
        // if( roleWrapper.getLevel() < XXX Level )

        // 各种判断是否能进入
        CheckpointConfig config = checkpointConfigService.loadById(checkpointId);

        Object[] additionalData = new Object[] { config.getId() };
        msgQueue.addStageControllMsg(StageControllCommands.INNER_APPLY_CHANGE_COPY, roleId, new Object[] { config.getMapId(), config.getInitial().getX(),
                config.getInitial().getY(), additionalData });

    }

    @Override
    public void createCheckpointCopy(String roleId, String stageId, String mapId, Object[] additionalData) {
        String checkpointId = (String) additionalData[0];

        MapConfig mapConfig = mapConfigService.load(mapId);
        CheckpointConfig checkpointConfig = checkpointConfigService.loadById(checkpointId);

        CheckpointStageCopy copy = CheckpointStageCopyFactory.create(stageId, checkpointConfig, mapConfig);

        stageService.addStageCopy(copy);
    }

    @Override
    public void expireCheck(String stageId, StageMsgQueue msgQueue) {
        CheckpointStageCopy stageCopy = (CheckpointStageCopy)stageService.getStage(stageId);
        if( null == stageCopy ) {
            return;
        }
        
        //角色已经退出
        IRole role = stageCopy.getChallenger();
        if( null == role ) { // && 不允许重新进入
            stageService.removeStage(stageId);
            return;
        }
        
        //超时
        if( !stageCopy.isFinished() && stageCopy.isExpired()  ) {
            stageCopy.setChallengeOver(true);
            
            stageCopy.scheduleForcedLeave();
        }
        
        stageCopy.scheduleExpireCheck();
    }

    @Override
    public void challengeOver(String stageId, StageMsgQueue msgQueue) {
        // TODO Auto-generated method stub

    }

    @Override
    public void applyLeaveCopy(String stageId, String roleId, StageMsgQueue msgQueue) {
        IStage stage = stageService.getStage(stageId);
        if (!stage.isCopy()) {
            return;
        }

        if (!(stage instanceof CheckpointStageCopy)) {
            return;
        }

        CheckpointStageCopy copy = (CheckpointStageCopy) stage;
        IRole role = copy.getChallenger();
        if (null != role) {
            copy.setExitNormal(true);
            deadLeaveCheckAndHandle(role);
            
            //返回请求退出结果
            msgQueue.addMsg(StageCommands.CHECKPOINT_LEAVE, roleId, new Object[]{1});
            
            //内部请求切换场景
            RoleLocation roleLocation = stageControllService.getHisMapPosition(roleId);
            msgQueue.addStageControllMsg(roleId, StageControllCommands.INNER_APPLY_CHANGE_MAP, roleLocation.enterPositionFormat());
        }
    }

    @Override
    public void forceLeave(String stageId, StageMsgQueue msgQueue) {
        // TODO Auto-generated method stub

    }

    private void deadLeaveCheckAndHandle(IRole role) {
        if (role.getStateManager().remove(StateType.DEAD)) {
            role.getFightAttribute().resetHpMp();
            role.getFightAttribute().resetHpMp();
            
//            StageMsgQueue localStageMsgQueue = new StageMsgQueue();
//            FightOutputWrapper.outputAttributeChange(role, localStageMsgQueue);
//            localStageMsgQueue.addMsg(role.getId(), "43001", role.getId());
//            localStageMsgQueue.flush();
        }
    }

}
