package com.simplegame.server.public_.guild.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.simplegame.core.data.accessor.AccessType;
import com.simplegame.core.data.accessor.dao.AbsDao;
import com.simplegame.server.public_.guild.dao.IGuildMemberDao;
import com.simplegame.server.public_.guild.entity.GuildMember;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年12月22日 下午4:08:30
 *
 */
@Component
public class GuildMemberDaoImpl extends AbsDao<GuildMember> implements IGuildMemberDao {

    @Override
    public void insertDb(GuildMember guildMember) {
        insert(guildMember, guildMember.getPrimaryKeyValue(), AccessType.getDirectDbType());
    }

    @Override
    public void deleteDb(GuildMember guildMember) {
        delete(guildMember, guildMember.getPrimaryKeyValue(), AccessType.getDirectDbType());
    }

    @Override
    public void updateDb(GuildMember guildMember) {
        update(guildMember, guildMember.getPrimaryKeyValue(), AccessType.getDirectDbType());
    }

    @Override
    public GuildMember getMemberByRoleIdDb(String roleId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userRoleId", roleId);
        
        List<GuildMember> list = getRecords(params);
        if( null != list && !list.isEmpty() ) {
            return list.get(0);
        }
        
        return null;
    }

    @Override
    public List<GuildMember> getMemberByGuildIdDb(String guildId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("guildId", guildId);
        
        return getRecords(params);
    }

    @Override
    public List<GuildMember> getMemberByPositionDb(String guildId, int position) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("guildId", guildId);
        params.put("position", position);
        
        return getRecords(params);
    }

}
