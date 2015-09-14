package com.simplegame.server.bus.checkpoint.action;

import javax.annotation.Resource;

import com.simplegame.core.action.annotation.ActionMapping;
import com.simplegame.core.action.annotation.ActionWorker;
import com.simplegame.core.message.Message;
import com.simplegame.server.bus.checkpoint.command.CheckpointCommands;
import com.simplegame.server.bus.swap.BusMsgSender;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年8月31日 下午5:32:51
 *
 */
@ActionWorker
public class CheckpointAction {
    
    @Resource
    private BusMsgSender busMsgSender;
    
    @ActionMapping(mapping = CheckpointCommands.ENTER)
    public void enter(Message message) {
        
    }
    
    @ActionMapping(mapping = CheckpointCommands.LEAVE)
    public void leave(Message message) {
        
    }
}
