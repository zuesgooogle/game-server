package com.simplegame.server.bus.client.io.moduleinit;

import org.springframework.stereotype.Component;

import com.simplegame.server.bus.client.io.ClientIoMuduleInfo;
import com.simplegame.server.bus.client.io.command.ClientIoCommands;
import com.simplegame.server.bus.share.moduleinit.BusModuleInit;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年6月30日 下午1:58:35
 *
 */
@Component
public class ClientIoModuleInit extends BusModuleInit {

    @Override
    protected InCmd getInCmd() {
        return new InCmd(ClientIoMuduleInfo.MODULE_NAME, "bus_init", new String[] { ClientIoCommands.ROLE_IN, ClientIoCommands.ROLE_OUT });
    }

}
