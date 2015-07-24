package com.simplegame.server.stage.swap;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.protocol.message.Message.DestType;
import com.simplegame.protocol.message.Message.FromType;
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
    
    public void sned2One(String command, String roleId, String stageId, Object data) {
        Object[] message = new Object[]{command, data, DestType.CLIENT.getValue(), FromType.STAGE.getValue(), 1, null, roleId, stageId, 0, null};
        
        swapManager.swap(message);
    }
}
