package com.simplegame.server.public_.guild.service;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年12月18日 下午6:30:55
 *
 */

public interface IGuildService {

    /**
     * 创建
     * 
     * @param roleId
     * @param guildName
     * @return
     */
    public Object[] createGuild(String roleId, String guildName);
    
    /**
     * 申请进入
     * 
     * @param roleId
     * @param guildId
     * @return
     */
    public Object[] applyGuild(String roleId, String guildId);
    
    /**
     * 申请审核
     * 
     * @param roleId
     * @param applyRoleId
     * @param guildId
     * @param agree     是否同意
     * @return
     */
    public Object[] applyConfirm(String roleId, String guildId, boolean agree);
    
    /**
     * 邀请
     * @param roleId
     * @param invitee   被邀请人
     * @param guildId
     * @return
     */
    public Object[] inviteGuild(String roleId, String invitee, String guildId);
    
    /**
     * 是否决定加入
     * 
     * @param roleId
     * @param guildId
     * @return
     */
    public Object[] inviteConfirm(String roleId, String guildId);
    
    /**
     * 退出
     * @param roleId
     * @param guildId
     * @return
     */
    public Object[] exitGuild(String roleId, String guildId);
    
    /**
     * 解散
     * 
     * @param roleId
     * @param guildId
     * @return
     */
    public Object[] deleteGuild(String roleId, String guildId);
}
