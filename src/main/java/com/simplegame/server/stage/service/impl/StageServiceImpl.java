package com.simplegame.server.stage.service.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.core.event.IEventService;
import com.simplegame.server.bus.map.configure.IMapConfigExportService;
import com.simplegame.server.stage.event.publish.StageCreateEvent;
import com.simplegame.server.stage.model.core.stage.IStage;
import com.simplegame.server.stage.model.stage.aoi.AoiStageFactory;
import com.simplegame.server.stage.service.IStageService;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月17日 上午11:15:41
 *
 */
@Component
public class StageServiceImpl implements IStageService {

    @Resource
    private IMapConfigExportService mapConfigExportService;
    
    @Resource
    private IEventService eventService;
    
    @Resource
    private AoiStageFactory aoiStageFactory;
    
    private ConcurrentMap<String, IStage> stageMap = new ConcurrentHashMap<String, IStage>();
    
    @Override
    public boolean checkAndCreateStage(String stageId, String mapId) {
        IStage stage = stageMap.get(stageId);
        if( null == stage ) {
            stage = aoiStageFactory.create(stageId, mapConfigExportService.load(mapId));
            stageMap.put(stageId, stage);
            
            //stage.getStageProduceManager().produceAll();
            
            eventService.publish(new StageCreateEvent(mapId, stageId));
            return true;
        }
        return false;
    }

    @Override
    public IStage getStage(String stageId) {
        return stageMap.get(stageId);
    }

    @Override
    public void removeStage(String stageId) {
        stageMap.remove(stageId);
    }
    
    @Override
    public boolean exist(String stageId) {
        return null != getStage(stageId);
    }

    @Override
    public boolean stageCanEnter(String stageId) {
        IStage stage = getStage(stageId);
        if( null == stage ) {
            return false;
        }
        
        return true;
    }

}
