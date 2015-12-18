package com.simplegame.server.public_.guild.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.simplegame.core.data.AbsVersion;
import com.simplegame.core.data.IEntity;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年12月18日 下午18:54:42
 * 
 */
public class Guild extends AbsVersion implements Serializable, IEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    private String userRoleId;

    /**
     * 总共战斗力
     */
    private int fighting;
    private Timestamp createTime;
    private Timestamp updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public int getFighting() {
        return fighting;
    }

    public void setFighting(int fighting) {
        this.fighting = fighting;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String getPirmaryKeyName() {
        return "id";
    }

    @Override
    public String getPrimaryKeyValue() {
        return getId();
    }

    @Override
    public IEntity copy() {
        Guild guild = new Guild();
        guild.setId(getId());
        guild.setName(getName());
        guild.setUserRoleId(getUserRoleId());
        guild.setFighting(getFighting());
        guild.setCreateTime(getCreateTime());
        guild.setUpdateTime(getUpdateTime());

        return guild;
    }

}