package com.simplegame.server.stage.service;

import com.simplegame.server.stage.model.core.stage.IStage;
import com.simplegame.server.stage.model.core.stage.Point;


/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月17日 上午11:11:09
 *
 */

public interface IStageService {
    
    /**
     * 角色离开场景
     * 
     * @param stageId
     * @param roleId
     * @return
     */
    public void roleLeaveStage(String stageId, String roleId);
    
    /**
     * 角色进入场景
     * 
     * @param stageId
     * @param roleId
     * @param mapId
     * @param x
     * @param y
     * @return
     */
    public void roleEnterStage(String stageId, String roleId, String mapId, int x, int y);

    public IStage getStage(String stageId);
    
    public void removeStage(String stageId);
    
    public boolean exist(String stageId);
    
    public boolean checkAndCreateStage(String stageId, String mapId);
    
    public boolean stageCanEnter(String stageId);

    /**
     * 角色是否可以切换地图
     * 
     * @param roleId
     * @param stageId
     * @return
     */
    public boolean roleCanChangeMap(String roleId, String stageId);
    
    public Point getPosition(String stageId, String roleId);
    
    public void addStageCopy(IStage stageCopy);
}
