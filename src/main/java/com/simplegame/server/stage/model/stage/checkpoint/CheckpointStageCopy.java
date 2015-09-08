package com.simplegame.server.stage.model.stage.checkpoint;

import java.util.HashMap;
import java.util.Map;

import com.simplegame.server.stage.command.StageCommands;
import com.simplegame.server.stage.model.core.stage.ElementType;
import com.simplegame.server.stage.model.core.stage.IStageElement;
import com.simplegame.server.stage.model.element.role.IRole;
import com.simplegame.server.stage.model.stage.copy.AbsStageCopy;
import com.simplegame.server.stage.model.stage.copy.ISingleStageCopy;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年9月2日 上午10:37:03
 * 
 */

public class CheckpointStageCopy extends AbsStageCopy implements ISingleStageCopy {

    private static long expireDelay = 60 * 3600 * 1000; // one hour

    private String checkpointId;

    private IRole challenger;
    
    public CheckpointStageCopy(String stageId, String mapId, String checkpointId) {
        this(stageId, mapId, checkpointId, expireDelay, System.currentTimeMillis(), new HashMap<String, Integer>());
    }

    public CheckpointStageCopy(String id, String mapId, String checkpointId, long expireDelay, long startTime, Map<String, Integer> killedMap) {
        super(id, mapId, 0, expireDelay, startTime, killedMap);

        this.checkpointId = checkpointId;
    }

    public String getChcekpointId() {
        return checkpointId;
    }

    @Override
    public void enter(IStageElement stageElement, int x, int y) {
        super.enter(stageElement, x, y);
        
        if (ElementType.isRole(stageElement.getElementType())) {
            challenger = (IRole)stageElement;
        }
    }
    
    @Override
    protected String getExpireCheckCommand() {
        return StageCommands.CHECKPOINT_EXPIRE_CHECK;
    }

    @Override
    protected String getForceLeaveCommand() {
        return StageCommands.CHECKPOINT_FORCE_CHECK;
    }

    @Override
    public IRole getChallenger() {
        return challenger;
    }

}
