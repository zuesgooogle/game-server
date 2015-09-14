package com.simplegame.server.bus.client.io.action;

import javax.annotation.Resource;

import com.simplegame.core.action.annotation.ActionMapping;
import com.simplegame.core.action.annotation.ActionWorker;
import com.simplegame.core.message.Message;
import com.simplegame.server.bus.client.io.command.ClientIoCommands;
import com.simplegame.server.bus.client.io.service.IIoService;

@ActionWorker
public class BusOutAction {
    
    @Resource
    private IIoService ioService;

    @ActionMapping(mapping = ClientIoCommands.ROLE_OUT)
    public void roleOut(Message message) {
        this.ioService.roleOut(message.getRoleId());
    }
}
