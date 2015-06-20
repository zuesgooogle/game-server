package com.simplegame.server.bus.swap;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.protocol.message.Message.DestType;
import com.simplegame.protocol.message.Message.FromType;
import com.simplegame.server.message.IMsgDispatcher;
import com.simplegame.server.message.manager.SwapManager;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年6月19日 下午6:35:59
 *
 */
@Component
public class BusMsgSender {

    @Resource
    private IMsgDispatcher busDispatcher;
    
    @Resource
    private SwapManager swapManager;
    
    
    public void send2BusInit(String command, String roleId, Object data) {
        Object[] message = new Object[]{command, data, DestType.BUS_INIT.getValue(), FromType.BUS.getValue(), 1, null, roleId, null, 0, null};
        
        busDispatcher.in(message);
    }
    
}
