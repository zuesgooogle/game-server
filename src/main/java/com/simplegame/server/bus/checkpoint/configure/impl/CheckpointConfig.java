package com.simplegame.server.bus.checkpoint.configure.impl;

import com.simplegame.core.data.AbsVersion;
import com.simplegame.core.data.IEntity;
import com.simplegame.server.stage.model.core.stage.Point;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年9月1日 下午2:44:22
 *
 */

public class CheckpointConfig extends AbsVersion implements IEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String id;
    
    /**
     * 前一关卡Id
     */
    private String preId;
    
    private String chapterId;
    
    private String mapId;
    
    /**
     * 人物进入关卡的默认坐标
     */
    private Point initial;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPreId() {
        return preId;
    }

    public void setPreId(String preId) {
        this.preId = preId;
    }

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getMapId() {
        return mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId;
    }

    public Point getInitial() {
        return initial;
    }

    public void setInitial(Point initial) {
        this.initial = initial;
    }

    @Override
    public String getPirmaryKeyName() {
        return "id";
    }

    @Override
    public Object getPrimaryKeyValue() {
        return getId();
    }

    @Override
    public IEntity copy() {
        return null;
    }
}
