package com.simplegame.server.bus.share.event.subscribe;

import com.simplegame.core.event.IEventHandler;

/**
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月23日 下午9:22:52
 * 
 */
public class BusEventCommandHandler implements IEventHandler {

	private String command;
	private String eventType;

	public BusEventCommandHandler(String command, String eventType) {
		this.command = command;
		this.eventType = eventType;
	}
	
	@Override
	public void handle(Object source, Object data) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getEventType() {
		return eventType;
	}

}
