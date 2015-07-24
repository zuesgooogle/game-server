package com.simplegame.server.bus.stagecontroll.position;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月20日 上午10:59:20
 *
 */

public class StageCopyPosition extends AbsRolePosition {

    private String stageId;
    
    private boolean stageExist;
    
    private Object[] additionalData;
    
    public StageCopyPosition(String stageId, String roleId, String mapId, int mapType, int x, int y) {
        super(roleId, mapId, mapType, x, y);
        this.stageId = stageId;
    }

    @Override
    public String getStageId() {
        return stageId;
    }

    public boolean isStageExist() {
        return stageExist;
    }

    public void setStageExist(boolean stageExist) {
        this.stageExist = stageExist;
    }

    public Object[] getAdditionalData() {
        return additionalData;
    }

    @Override
    public Object[] enterPositionFormat() {
        return new Object[]{getStageId(), getMapId(), getX(), getY()};
    }


}
