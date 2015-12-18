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
public class GuildMember extends AbsVersion implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;

    private String guildId;
    private String userRoleId;
    private int position;

    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp logUpdateTime;

    public String getGuildId() {
        return guildId;
    }

    public void setGuildId(String guildId) {
        this.guildId = guildId;
    }

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
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

    public GuildMember copy() {
        GuildMember member = new GuildMember();
        member.setGuildId(getGuildId());
        member.setUserRoleId(getUserRoleId());
        member.setPosition(getPosition());
        member.setCreateTime(getCreateTime());
        member.setUpdateTime(getUpdateTime());
        member.setLogUpdateTime(getLogUpdateTime());
        
        return member;
    }
}