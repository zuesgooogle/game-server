package com.simplegame.server.public_.share;

import java.util.List;

import javax.annotation.Resource;

import com.simplegame.core.event.IEventService;
import com.simplegame.server.public_.event.PublicEventHandler;
import com.simplegame.server.public_.swap.PublicMsgSender;
import com.simplegame.server.share.event.EventHandleCommands;
import com.simplegame.server.share.event.EventHandleCommands.Node;
import com.simplegame.server.share.export.IEntityCacheLoaderExportService;
import com.simplegame.server.share.moduleinit.ModuleInit;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月7日 下午6:36:09
 * 
 */

public abstract class PublicModuleInit extends ModuleInit {

    @Resource
    private IEventService eventService;
    
    @Resource
    private PublicMsgSender publicMsgSender;

    @Resource
    private IEntityCacheLoaderExportService publicCacheLoaderExportService;

    public void init() {
        super.init();

        if (null != getEventHandleCommands()) {
            List<Node> nodeList = getEventHandleCommands().nodes();
            for (Node node : nodeList) {
                this.eventService.subscribe(node.getEventType(), getOrder(), new PublicEventHandler(publicMsgSender, node.getEventType(), node.getCommand()));
            }
        }
    }

    @Override
    public IEntityCacheLoaderExportService getEntityCacheLoaderExportService() {
        return publicCacheLoaderExportService;
    }

    public abstract EventHandleCommands getEventHandleCommands();

    @Override
    public IEventService getEventService() {
        return eventService;
    }

}
