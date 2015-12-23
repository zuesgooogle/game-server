package com.simplegame.server.public_.guild.moduleinit;

import org.springframework.stereotype.Component;

import static com.simplegame.server.public_.guild.command.GuildCommands.*;

import com.simplegame.server.public_.guild.GuildModuleInfo;
import com.simplegame.server.public_.share.PublicModuleInit;
import com.simplegame.server.share.event.EventHandleCommands;
import com.simplegame.server.share.moduleinit.Group;
import com.simplegame.server.share.moduleinit.ModuleInit;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年12月23日 下午5:51:21
 * 
 */
@Component
public class GuildModuleInit extends PublicModuleInit {

    @Override
    public EventHandleCommands getEventHandleCommands() {
        return null;
    }
    
    @Override
    protected InCmd getInCmd() {
        String[] cmds = new String[]{CREATE_GUILD, APPLY_ADD, APPLY_ADD_CONFIRM, INVITE_ADD, INVITE_ADD_CONFIRM, EXIT_GUILD};
        
        return new InCmd(GuildModuleInfo.MODULE_NAME, Group.PUBLIC.name, cmds);
    }

    @Override
    protected ModuleInit.ModuleInfo getModuleInfo() {
        return new ModuleInfo(GuildModuleInfo.MODULE_NAME, GuildModuleInfo.MODULE_NAME_ABBR);
    }

}
