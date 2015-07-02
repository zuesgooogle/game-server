package com.simplegame.server.bus.stagecontroll.action;

import javax.annotation.Resource;

import com.simplegame.core.action.annotation.ActionMapping;
import com.simplegame.core.action.annotation.ActionWorker;
import com.simplegame.protocol.message.Message;
import com.simplegame.server.bus.stagecontroll.command.StageControllCommands;
import com.simplegame.server.bus.stagecontroll.service.IStageControllService;
import com.simplegame.server.bus.swap.BusMsgSender;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月2日 下午5:29:09
 *
 */
@ActionWorker
public class StageControllAction {

    @Resource
    private BusMsgSender busMsgSender;
    
    @Resource
    private IStageControllService stageControllService;
    
    @ActionMapping(mapping = StageControllCommands.LOGIN)
    public void login(Message message) {
        String roleId = message.getRoleId();
        
        Object result = stageControllService.login(roleId);
        busMsgSender.send2One(StageControllCommands.LOGIN, roleId, result);
    }
    
}
