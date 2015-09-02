package com.simplegame.server.stage.model.stage.checkpoint;

import com.simplegame.server.stage.model.stage.aoi.AoiStage;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年9月2日 上午10:37:03
 *
 */

public class CheckpointStageCopy extends AoiStage {

    private String checkpointId;
    
    public CheckpointStageCopy(String id, String mapId, String checkpointId) {
        super(id, mapId);
        this.checkpointId = checkpointId;
    }

    public String getChcekpointId() {
        return checkpointId;
    }
    
}
