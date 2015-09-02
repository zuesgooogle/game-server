package com.simplegame.server.stage.swap;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.protocol.message.Message.DestType;
import com.simplegame.protocol.message.Message.FromType;
import com.simplegame.server.message.IMsgDispatcher;
import com.simplegame.server.message.manager.SwapManager;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月21日 下午4:45:56
 *
 */
@Component
public class StageMsgSender {

    @Resource
    private SwapManager swapManager;
    
    @Resource
    private IMsgDispatcher stageMsgDispatcher; 
    
    public void sned2One(String command, String roleId, String stageId, Object data) {
        Object[] message = new Object[]{command, data, DestType.CLIENT.getValue(), FromType.STAGE.getValue(), 1, null, roleId, stageId, 0, null};
        
        swapManager.swap(message);
    }
    
    public void send2StageControl(String command, String roleId, Object data) {
        Object[] message = new Object[]{command, data, DestType.STAGE_CONTROL.getValue(), FromType.STAGE.getValue(), 1, null, roleId, null, 0, null};
    
        stageMsgDispatcher.in(message);
    }
}
