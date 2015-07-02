package com.simplegame.server.bus.stage.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.simplegame.core.data.AbsVersion;
import com.simplegame.core.data.IEntity;

public class RoleStage extends AbsVersion implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;

    private String userRoleId;
    private String mapId;
    private Integer mapX;
    private Integer mapY;
    private Integer hp;
    private Integer mp;
    private Integer maxHp;
    private Integer maxMp;
    private String buff;
    private String props;
    private Integer state;
    private String mapNode;
    private Integer tiLi;
    private Integer lineNo;
    private String pkInfo;
    private Integer shanbiVal;
    private String meirenInfo;
    private String zuoqiInfo;
    private Integer freeFlyCount;
    private Long flyCountRefreshTime;
    private String copyInfo;
    private Timestamp logUpdateTime;

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getMapId() {
        return mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId;
    }

    public Integer getMapX() {
        return mapX;
    }

    public void setMapX(Integer mapX) {
        this.mapX = mapX;
    }

    public Integer getMapY() {
        return mapY;
    }

    public void setMapY(Integer mapY) {
        this.mapY = mapY;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getMp() {
        return mp;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public Integer getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(Integer maxHp) {
        this.maxHp = maxHp;
    }

    public Integer getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(Integer maxMp) {
        this.maxMp = maxMp;
    }

    public String getBuff() {
        return buff;
    }

    public void setBuff(String buff) {
        this.buff = buff;
    }

    public String getProps() {
        return props;
    }

    public void setProps(String props) {
        this.props = props;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMapNode() {
        return mapNode;
    }

    public void setMapNode(String mapNode) {
        this.mapNode = mapNode;
    }

    public Integer getTiLi() {
        return tiLi;
    }

    public void setTiLi(Integer tiLi) {
        this.tiLi = tiLi;
    }

    public Integer getLineNo() {
        return lineNo;
    }

    public void setLineNo(Integer lineNo) {
        this.lineNo = lineNo;
    }

    public String getPkInfo() {
        return pkInfo;
    }

    public void setPkInfo(String pkInfo) {
        this.pkInfo = pkInfo;
    }

    public Integer getShanbiVal() {
        return shanbiVal;
    }

    public void setShanbiVal(Integer shanbiVal) {
        this.shanbiVal = shanbiVal;
    }

    public String getMeirenInfo() {
        return meirenInfo;
    }

    public void setMeirenInfo(String meirenInfo) {
        this.meirenInfo = meirenInfo;
    }

    public String getZuoqiInfo() {
        return zuoqiInfo;
    }

    public void setZuoqiInfo(String zuoqiInfo) {
        this.zuoqiInfo = zuoqiInfo;
    }

    public Integer getFreeFlyCount() {
        return freeFlyCount;
    }

    public void setFreeFlyCount(Integer freeFlyCount) {
        this.freeFlyCount = freeFlyCount;
    }

    public Long getFlyCountRefreshTime() {
        return flyCountRefreshTime;
    }

    public void setFlyCountRefreshTime(Long flyCountRefreshTime) {
        this.flyCountRefreshTime = flyCountRefreshTime;
    }

    public String getCopyInfo() {
        return copyInfo;
    }

    public void setCopyInfo(String copyInfo) {
        this.copyInfo = copyInfo;
    }

    public Timestamp getLogUpdateTime() {
        return logUpdateTime;
    }

    public void setLogUpdateTime(Timestamp logUpdateTime) {
        this.logUpdateTime = logUpdateTime;
    }

    public String getPirmaryKeyName() {
        return "userRoleId";
    }

    public String getPrimaryKeyValue() {
        return getUserRoleId();
    }

    public RoleStage copy() {
        RoleStage roleStage = new RoleStage();
        roleStage.setUserRoleId(getUserRoleId());
        roleStage.setMapId(getMapId());
        roleStage.setMapX(getMapX());
        roleStage.setMapY(getMapY());
        roleStage.setHp(getHp());
        roleStage.setMp(getMp());
        roleStage.setMaxHp(getMaxHp());
        roleStage.setMaxMp(getMaxMp());
        roleStage.setBuff(getBuff());
        roleStage.setProps(getProps());
        roleStage.setState(getState());
        roleStage.setMapNode(getMapNode());
        roleStage.setTiLi(getTiLi());
        roleStage.setLineNo(getLineNo());
        roleStage.setPkInfo(getPkInfo());
        roleStage.setShanbiVal(getShanbiVal());
        roleStage.setMeirenInfo(getMeirenInfo());
        roleStage.setFreeFlyCount(getFreeFlyCount());
        roleStage.setFlyCountRefreshTime(getFlyCountRefreshTime());
        roleStage.setZuoqiInfo(getZuoqiInfo());
        roleStage.setCopyInfo(getCopyInfo());
        roleStage.setLogUpdateTime(getLogUpdateTime());
        return roleStage;
    }
}