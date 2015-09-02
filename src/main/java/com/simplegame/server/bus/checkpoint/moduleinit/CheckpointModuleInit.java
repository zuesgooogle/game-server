package com.simplegame.server.bus.checkpoint.moduleinit;

import static com.simplegame.server.bus.checkpoint.CheckpointModuleInfo.*;
import static com.simplegame.server.bus.checkpoint.command.CheckpointCommands.*;

import org.springframework.stereotype.Component;

import com.simplegame.server.bus.share.moduleinit.BusModuleInit;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年8月31日 下午5:26:43
 *
 */
@Component
public class CheckpointModuleInit extends BusModuleInit {

    @Override
    protected InCmd getInCmd() {
        String[] cmds = new String[]{ENTER, LEAVE};
        
        return new InCmd(MODULE_NAME, MODULE_NAME_ALIAS, cmds);
    }

}
