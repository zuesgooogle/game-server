package com.simplegame.server.public_.guild.service.impl;

import org.springframework.stereotype.Component;

import com.simplegame.server.public_.guild.service.IGuildService;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年12月18日 下午6:43:17
 *
 */
@Component
public class GuildServiceImpl implements IGuildService {

    @Override
    public Object[] createGuild(String roleId, String guildName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] applyGuild(String roleId, String guildId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] applyConfirm(String roleId, String guildId, boolean agree) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] inviteGuild(String roleId, String invitee, String guildId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] inviteConfirm(String roleId, String guildId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] exitGuild(String roleId, String guildId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] deleteGuild(String roleId, String guildId) {
        // TODO Auto-generated method stub
        return null;
    }

}
