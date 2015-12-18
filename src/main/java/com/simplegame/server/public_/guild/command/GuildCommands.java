package com.simplegame.server.public_.guild.command;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年12月18日 下午18:54:42
 * 
 */
public class GuildCommands {
    
    /**
     * 创建帮派
     */
    public static final String CREATE_GUILD = "53000";
    
    /**
     * 申请加入
     */
    public static final String APPLY_ADD = "53001";
    public static final String APPLY_ADD_CONFIRM = "53002";
    
    /**
     * 邀请加入
     */
    public static final String INVITE_ADD = "53003";
    public static final String INVITE_ADD_CONFIRM = "53004";

    /**
     * 退出帮派
     */
    public static final String EXIT_GUILD = "53005";
    
    /**
     * 根据角色ID，获取自己帮派信息
     */
    public static final String GET_GUILD_BY_ROLEID = "53006";
    
    /**
     * 删除，解散帮派
     */
    public static final String DELETE_GUILD = "53007";

}