package com.simplegame.server.stage.service;

import com.simplegame.server.stage.model.core.stage.IStage;


/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月17日 上午11:11:09
 *
 */

public interface IStageService {

    public IStage getStage(String stageId);
    
    public void removeStage(String stageId);
    
    public boolean exist(String stageId);
    
    public boolean checkAndCreateStage(String stageId, String mapId);
    
    public boolean stageCanEnter(String stageId);
    
}
