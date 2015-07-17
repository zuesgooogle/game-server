package com.simplegame.server.bus.stage.export;

import java.io.Serializable;

import com.simplegame.server.stage.entity.RoleStage;

public class RoleStageWrapper implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private RoleStage roleStage;

    public RoleStageWrapper() {
    }

    public RoleStageWrapper(RoleStage roleStage) {
        this.roleStage = roleStage;
    }

    public RoleStage getRoleStage() {
        return this.roleStage;
    }

    public void setRoleStage(RoleStage roleStage) {
        this.roleStage = roleStage;
    }

    public String getUserRoleId() {
        return this.roleStage.getUserRoleId();
    }

    public String getMapNode() {
        return this.roleStage.getMapNode();
    }

    public String getMapId() {
        return this.roleStage.getMapId();
    }

    public Integer getMapX() {
        return this.roleStage.getMapX();
    }

    public Integer getMapY() {
        return this.roleStage.getMapY();
    }

    public Integer getHp() {
        return this.roleStage.getHp();
    }

    public Integer getMp() {
        return this.roleStage.getMp();
    }

    public Integer getMaxHp() {
        return this.roleStage.getMaxHp();
    }

    public Integer getMaxMp() {
        return this.roleStage.getMaxMp();
    }

    public String getBuff() {
        return this.roleStage.getBuff();
    }

    public Integer getState() {
        return this.roleStage.getState();
    }

    public boolean isDead() {
        return new Integer(1).equals(getState());
    }

    public int getTiLi() {
        return this.roleStage.getTiLi().intValue();
    }

    public Integer getLineNo() {
        return this.roleStage.getLineNo();
    }

    public int getPkVal() {
//        String str = this.roleStage.getPkInfo();
//        Map localMap = MapUtil.convertStr2Map(str);
//        if (localMap != null) {
//            Long localLong = (Long) localMap.get("pkVal");
//            return localLong == null ? 0 : localLong.intValue();
//        }
        return 0;
    }

    public String getPkInfo() {
        return this.roleStage.getPkInfo();
    }

//    public Object[] getCopyInfo() {
//        return RoleStageUtil.decodeOfflineCopy(this.roleStage.getCopyInfo());
//    }
}