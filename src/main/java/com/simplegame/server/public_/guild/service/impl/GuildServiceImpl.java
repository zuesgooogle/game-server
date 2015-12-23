package com.simplegame.server.public_.guild.service.impl;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.simplegame.server.bus.id.export.IdGenerator;
import com.simplegame.server.bus.role.export.IRoleExportService;
import com.simplegame.server.bus.role.export.RoleWrapper;
import com.simplegame.server.public_.guild.GuildModuleInfo;
import com.simplegame.server.public_.guild.dao.IGuildDao;
import com.simplegame.server.public_.guild.dao.IGuildMemberDao;
import com.simplegame.server.public_.guild.entity.Guild;
import com.simplegame.server.public_.guild.entity.GuildMember;
import com.simplegame.server.public_.guild.output.GuildOutput;
import com.simplegame.server.public_.guild.service.IGuildService;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年12月18日 下午6:43:17
 *
 */
@Component
public class GuildServiceImpl implements IGuildService {

    @Resource
    private IRoleExportService roleExportService;
    
    @Resource
    private IGuildDao guildDao;
    
    @Resource
    private IGuildMemberDao guildMemberDao;
    
    @Resource
    private IdGenerator idGenerator;
    
    @Override
    public Object[] createGuild(String roleId, String guildName) {
        RoleWrapper roleWrapper = roleExportService.getRole(roleId);
        
        Object[] checkResult = checkCreateGuild(roleWrapper, guildName);
        if( checkResult != null ) {
            return checkResult;
        }
        
        //TODO 扣除货币 || 物品
        
        String id = idGenerator.getId4Module(GuildModuleInfo.MODULE_NAME);
        Guild guild = new Guild();
        guild.setId(id);
        guild.setName(guildName);
        guild.setUserRoleId(roleId);
        guild.setCreateTime(new Timestamp(System.currentTimeMillis()));
        this.guildDao.insertDb(guild);
        
        //add member
        GuildMember member = new GuildMember();
        member.setGuildId(id);
        member.setUserRoleId(roleId);
        member.setPosition(0);
        member.setCreateTime(new Timestamp(System.currentTimeMillis()));
        this.guildMemberDao.insertDb(member);
        
        //TODO 返回信息
        
        return null;
    }

    private Object[] checkCreateGuild(RoleWrapper roleWrapper, String guildName) {
        if( StringUtils.isEmpty(guildName) ) {
            return GuildOutput.guildNameNotNull();
        }

        if( guildName.length() < 2 || guildName.length() > 6 ) {
            return GuildOutput.guildNameStringlength();
        }
        
        //TODO 过滤词验证
        
        boolean exist = guildDao.getGuildByNameDb(guildName);
        if( exist ) {
            return GuildOutput.guildNameExisted();
        }
        
        //TODO 货币 || 道具消耗验证
        
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
