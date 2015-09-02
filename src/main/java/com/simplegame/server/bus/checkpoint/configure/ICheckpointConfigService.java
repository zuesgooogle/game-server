package com.simplegame.server.bus.checkpoint.configure;

import com.simplegame.server.bus.checkpoint.configure.impl.CheckpointConfig;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年9月1日 下午2:43:33
 *
 */

public interface ICheckpointConfigService {

    public CheckpointConfig loadById(String id);
    
}
