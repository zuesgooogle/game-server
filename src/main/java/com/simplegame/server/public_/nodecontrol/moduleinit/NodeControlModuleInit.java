package com.simplegame.server.public_.nodecontrol.moduleinit;

import org.springframework.stereotype.Component;

import com.simplegame.server.public_.nodecontrol.NodeControlModuleInfo;
import com.simplegame.server.public_.nodecontrol.command.NodeControlCommands;
import com.simplegame.server.public_.share.PublicModuleInit;
import com.simplegame.server.share.event.EventHandleCommands;
import com.simplegame.server.share.moduleinit.Group;

@Component
public class NodeControlModuleInit extends PublicModuleInit {
    
    protected InCmd getInCmd() {
        return new InCmd(NodeControlModuleInfo.MODULE_NAME, Group.PUBLIC.name, new String[] { NodeControlCommands.ROLE_IN, NodeControlCommands.ROLE_OUT });
    }

    @Override
    public EventHandleCommands getEventHandleCommands() {
        return null;
    }
}
