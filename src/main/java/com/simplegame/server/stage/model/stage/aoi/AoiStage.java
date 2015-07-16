package com.simplegame.server.stage.model.stage.aoi;

import com.simplegame.server.stage.model.core.stage.AbsStage;
import com.simplegame.server.stage.model.core.stage.IStageElement;
import com.simplegame.server.stage.model.core.stage.StageType;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年7月16日 下午3:44:06
 * 
 */

public class AoiStage extends AbsStage {

    private String id;

    private String mapId;

    public AoiStage(String id, String mapId) {
        this.id = id;
        this.mapId = mapId;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getMapId() {
        return mapId;
    }

    @Override
    protected void addHandler(IStageElement stageElement) {
        stageElement.enterStageHandle(this);
    }

    @Override
    protected void deleteHandler(IStageElement stageElement) {
        stageElement.leaveStageHandle(this);
    }

    public StageType getStageType() {
        return StageType.NORMAL;
    }

}
