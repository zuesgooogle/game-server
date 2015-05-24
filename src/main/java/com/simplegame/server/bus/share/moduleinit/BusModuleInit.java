package com.simplegame.server.bus.share.moduleinit;

import java.util.List;

import javax.annotation.Resource;

import com.simplegame.core.event.IEventService;
import com.simplegame.server.bus.share.event.subscribe.BusEventCommandHandler;
import com.simplegame.server.share.event.EventHandleCommands;
import com.simplegame.server.share.event.EventHandleCommands.Node;
import com.simplegame.server.share.moduleinit.ModuleInit;

/**
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月23日 下午9:20:33
 * 
 */
public abstract class BusModuleInit extends ModuleInit {

	@Resource
	private IEventService eventService;

	public void init() {
		super.init();
		
		if (null != getEventHandleCommands()) {
			List<Node> nodeList = getEventHandleCommands().nodes();
			for (Node node : nodeList) {
				this.eventService.subscribe(node.getEventType(), getOrder(), new BusEventCommandHandler(node.getEventType(), node.getCommand()));
			}
		}
	}

	protected EventHandleCommands getEventHandleCommands() {
		return null;
	}
	
	@Override
	public IEventService getEventService() {
		return eventService;
	}

}
