package com.simplegame.server.public_.nodecontrol.action;

import javax.annotation.Resource;

import com.simplegame.core.action.annotation.ActionMapping;
import com.simplegame.core.action.annotation.ActionWorker;
import com.simplegame.protocol.message.Message;
import com.simplegame.server.public_.nodecontrol.command.NodeControlCommands;
import com.simplegame.server.public_.nodecontrol.service.INodeControlService;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年6月19日 下午5:47:40
 *
 */
@ActionWorker
public class NodeControlAction {

    @Resource
    private INodeControlService nodeContorlService;
    
    @ActionMapping(mapping = NodeControlCommands.ROLE_IN)
    public void roleIn(Message message) {
        String roleId = message.getRoleId();
        
        nodeContorlService.change2offline(roleId);
        nodeContorlService.nodeLogin(roleId, "ip");
    }
    
    @ActionMapping(mapping = NodeControlCommands.ROLE_OUT)
    public void roleOut(Message message) {
        String roleId = message.getRoleId();
        
        nodeContorlService.nodeExit(roleId, "ip");
    }
    
}
