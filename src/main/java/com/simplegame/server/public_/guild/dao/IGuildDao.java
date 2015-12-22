package com.simplegame.server.public_.guild.dao;

import java.util.List;

import com.simplegame.server.public_.guild.entity.Guild;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年12月22日 下午3:49:57
 * 
 */

public interface IGuildDao {

    public void insertDb(Guild guild);

    public void deleteDb(Guild guild);

    public void updateDb(Guild guild);

    public Guild getGuildByIdDb(String guildId);

    public Guild getGuildByRoleIdDb(String roleId);

    public boolean getGuildByNameDb(String guildName);

    public List<Guild> getAllGuilds();

    public List<Guild> getGuildByLikeNameDb(String guildName);

}
