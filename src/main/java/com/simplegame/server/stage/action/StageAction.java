package com.simplegame.server.stage.action;

import static com.simplegame.server.stage.command.StageCommands.*;

import javax.annotation.Resource;

import com.simplegame.core.action.annotation.ActionMapping;
import com.simplegame.core.action.annotation.ActionWorker;
import com.simplegame.protocol.message.Message;
import com.simplegame.server.stage.service.IStageService;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年9月7日 上午11:41:28
 *
 */
@ActionWorker
public class StageAction {

    @Resource
    private IStageService stageService;
    
    @ActionMapping(mapping = INNER_ENTER_STAGE)
    public void enter(Message message) {
        String roleId = message.getRoleId();
        
        Object[] data = (Object[]) message.getData();
        String stageId = (String)data[0];
        String mapId = (String)data[1];
        int x = (Integer)data[2];
        int y = (Integer)data[3];
        
        stageService.roleEnterStage(stageId, roleId, mapId, x, y);
    }
    
    @ActionMapping(mapping = INNER_LEAVE_STAGE)
    public void leave(Message message) {
        String roleId = message.getRoleId();
        
        Object[] data = (Object[]) message.getData();
        String stageId = (String)data[0];
        
        stageService.roleLeaveStage(stageId, roleId);
    }
    
}
