package com.simplegame.server.public_.guild.dao;

import java.util.List;

import com.simplegame.server.public_.guild.entity.GuildMember;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年12月22日 下午4:04:44
 *
 */

public interface IGuildMemberDao {

    public void insertDb(GuildMember guildMember);
    
    public void deleteDb(GuildMember guildMember);
    
    public void updateDb(GuildMember guildMember);
    
    public GuildMember getMemberByRoleIdDb(String roleId);
    
    public List<GuildMember> getMemberByGuildIdDb(String guildId);
    
    public List<GuildMember> getMemberByPositionDb(String guildId, int position);
}
