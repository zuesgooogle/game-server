package com.simplegame.server.bus.client.io.export.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.server.bus.client.io.command.ClientIoCommands;
import com.simplegame.server.bus.client.io.export.IClientIoExportService;
import com.simplegame.server.bus.swap.BusMsgSender;

@Component
public class ClientIoExportServiceImpl implements IClientIoExportService {
    
    @Resource
    private BusMsgSender busMsgSender;
    
    public void roleIn(String roleId, String paramString2) {
        busMsgSender.send2BusInit(ClientIoCommands.ROLE_IN, roleId, paramString2);
    }

    public void roleOut(String roleId) {
        busMsgSender.send2BusInit(ClientIoCommands.ROLE_OUT, roleId, null);
    }
}