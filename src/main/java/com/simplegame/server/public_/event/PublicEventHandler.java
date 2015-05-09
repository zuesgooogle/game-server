package com.simplegame.server.public_.event;

import com.simplegame.core.event.IEventHandler;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月7日 下午6:32:54
 *
 */

public class PublicEventHandler implements IEventHandler {

	private String command;
	
	private String eventType;
	
	public PublicEventHandler(String command, String eventType) {
		this.command = command;
		this.eventType = eventType;
	}
	
	@Override
	public void handle(Object source, Object data) {
		//public msg sender
	}

	@Override
	public String getEventType() {
		return eventType;
	}

}
