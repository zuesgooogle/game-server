package com.simplegame.server.stage.model.stage.checkpoint;

import com.simplegame.server.bus.checkpoint.configure.impl.CheckpointConfig;
import com.simplegame.server.bus.map.configure.impl.MapConfig;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年9月2日 上午10:40:54
 *
 */

public class CheckpointStageCopyFactory {

    public static CheckpointStageCopy create(String stageId, CheckpointConfig checkpointConfig, MapConfig mapConfig) {
        CheckpointStageCopy copy = new CheckpointStageCopy(stageId, mapConfig.getId(), checkpointConfig.getId());
    
        /**
         * 其他相关逻辑
         */
        
        return copy;
    }
    
}
