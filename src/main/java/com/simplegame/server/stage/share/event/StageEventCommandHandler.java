package com.simplegame.server.stage.share.event;

import com.simplegame.core.event.IEventHandler;
import com.simplegame.server.bus.swap.BusMsgSender;

/**
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月23日 下午9:22:52
 * 
 */
public class StageEventCommandHandler implements IEventHandler {

    private BusMsgSender busMsgSender;
    
	private String command;
	
	private String eventType;

	public StageEventCommandHandler(BusMsgSender busMsgSender, String command, String eventType) {
	    this.busMsgSender = busMsgSender;
		this.command = command;
		this.eventType = eventType;
	}
	
	@Override
	public void handle(Object source, Object data) {
	    busMsgSender.send2Stage(command, (String)source, data);
	}

	@Override
	public String getEventType() {
		return eventType;
	}

}
