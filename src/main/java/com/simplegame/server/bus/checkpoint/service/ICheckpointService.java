package com.simplegame.server.bus.checkpoint.service;

import com.simplegame.server.stage.swap.StageMsgQueue;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年8月31日 下午5:41:23
 *
 */

public interface ICheckpointService {

    /**
     * 请求进入副本
     * 
     * @param roleId
     * @param checkpointId
     * @param msgQueue
     */
    public void enterCopy(String roleId, String checkpointId, StageMsgQueue msgQueue);
    
    /**
     * 创建副本
     * 
     * @param roleId
     * @param stageId
     * @param mapId
     */
    public void createCheckpointCopy(String roleId, String stageId, String mapId, Object[] additionalData);
}
