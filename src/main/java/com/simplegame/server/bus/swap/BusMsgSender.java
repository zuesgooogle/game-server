package com.simplegame.server.bus.swap;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.core.message.Message;
import com.simplegame.core.message.Message.DestType;
import com.simplegame.core.message.Message.FromType;
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
    private IMsgDispatcher gsDispatcher;
    
    
    @Resource
    private SwapManager swapManager;
    
    
    public void send2BusInner(String command, String roleId, Object data) {
        //Object[] message = new Object[]{command, data, DestType.STAGE_CONTROL.getValue(), FromType.BUS.getValue(), 1, null, roleId, null, 0, null};
        Message message = new Message(command, data, FromType.BUS, DestType.STAGE_CONTROL, roleId);
        
        busDispatcher.in(message);
    }
    
    public void send2BusInit(String command, String roleId, Object data) {
        Message message = new Message(command, data, FromType.BUS, DestType.BUS_INIT, roleId);
        
        busDispatcher.in(message);
    }
    
    public void send2One(String command, String roleId, Object data) {
        //Object[] message = new Object[]{command, data, DestType.CLIENT.getValue(), FromType.BUS.getValue(), 1, null, roleId, null, 0, null};
        
        Message message = new Message(command, data, FromType.BUS, DestType.CLIENT, roleId);
        message.setRoute(1); // send to one player
        
        swapManager.swap(message);
    }
    
    public void send2Stage(String command, String roleId, Object data) {
        //Object[] message = new Object[]{command, data, DestType.BUS.getValue(), FromType.BUS.getValue(), 1, null, roleId, null, 0, null};
        
        Message message = new Message(command, data, FromType.BUS, DestType.STAGE, roleId);
        
        gsDispatcher.in(message);
    }
    
}
