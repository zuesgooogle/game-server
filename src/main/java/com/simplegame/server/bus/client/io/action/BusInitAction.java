package com.simplegame.server.bus.client.io.action;

import javax.annotation.Resource;

import com.simplegame.core.action.annotation.ActionMapping;
import com.simplegame.core.action.annotation.ActionWorker;
import com.simplegame.protocol.message.Message;
import com.simplegame.server.bus.client.io.command.ClientIoCommands;
import com.simplegame.server.bus.client.io.service.IIoService;

@ActionWorker
public class BusInitAction {
    
    @Resource
    private IIoService ioService;

    @ActionMapping(mapping = ClientIoCommands.ROLE_IN)
    public void roleIn(Message message) {
        String str = (String) message.getData();
        this.ioService.roleIn(message.getRoleId(), str);
    }
}
