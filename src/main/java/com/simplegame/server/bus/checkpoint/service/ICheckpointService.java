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
    
    /**
     * 超时检查
     * 
     * @param stageId
     * @param msgQueue
     */
    public void expireCheck(String stageId, StageMsgQueue msgQueue);
    
    /**
     * 挑战结束
     * 
     * @param stageId
     * @param msgQueue
     */
    public void challengeOver(String stageId, StageMsgQueue msgQueue);
    
    /**
     * 申请退出副本
     * 
     * @param stageId
     * @param roleId
     * @param msgQueue
     */
    public void applyLeaveCopy(String stageId, String roleId, StageMsgQueue msgQueue);
    
    /**
     * 强制退出副本
     * 
     * @param stageId
     * @param msgQueue
     */
    public void forceLeave(String stageId, StageMsgQueue msgQueue);
}
