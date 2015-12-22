package com.simplegame.server.public_.guild.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.simplegame.core.data.accessor.AccessType;
import com.simplegame.core.data.accessor.dao.AbsDao;
import com.simplegame.server.public_.guild.dao.IGuildDao;
import com.simplegame.server.public_.guild.entity.Guild;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年12月22日 下午3:51:50
 *
 */
@Component
public class GuildDaoImpl extends AbsDao<Guild> implements IGuildDao {

    @Override
    public void insertDb(Guild guild) {
        insert(guild, guild.getPrimaryKeyValue(), AccessType.getDirectDbType());
    }

    @Override
    public void deleteDb(Guild guild) {
        delete(guild, guild.getPrimaryKeyValue(), AccessType.getDirectDbType());
    }

    @Override
    public void updateDb(Guild guild) {
        update(guild, guild.getPrimaryKeyValue(), AccessType.getDirectDbType());
    }

    @Override
    public Guild getGuildByIdDb(String guildId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", guildId);
        
        List<Guild> list = getRecords(params);
        if( null != list && !list.isEmpty() ) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Guild getGuildByRoleIdDb(String roleId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userRoleId", roleId);
        
        List<Guild> list = getRecords(params);
        if( null != list && !list.isEmpty() ) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public boolean getGuildByNameDb(String guildName) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", guildName);
        
        List<Guild> list = getRecords(params);

        return list != null && !list.isEmpty();
    }

    @Override
    public List<Guild> getAllGuilds() {
        Map<String, Object> params = new HashMap<String, Object>();
        return getRecords(params);
    }

    @Override
    public List<Guild> getGuildByLikeNameDb(String guildName) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", "%" + guildName + "%");
        
        return query("selectGuildLikeName", params);
    }
}
