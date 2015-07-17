package com.simplegame.server.bus.stagecontroll.moduleinit;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.core.event.IEventHandler;
import com.simplegame.server.bus.share.moduleinit.BusModuleInit;
import com.simplegame.server.bus.stagecontroll.StageControllModuleInfo;
import com.simplegame.server.bus.stagecontroll.command.StageControllCommands;
import com.simplegame.server.bus.stagecontroll.event.subscribe.RoleLoginHandler;
import com.simplegame.server.bus.stagecontroll.event.subscribe.RoleLogoutHandler;
import com.simplegame.server.bus.stagecontroll.service.IStageControllService;
import com.simplegame.server.share.moduleinit.CommandGroup;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月2日 下午5:35:22
 *
 */
@Component
public class StageControllMuduleInit extends BusModuleInit {

    @Resource
    private RoleLoginHandler roleLoginHandler;
    
    @Resource
    private RoleLogoutHandler roleLogoutHandler;
    
    @Resource
    private IStageControllService stageControllService;
    
    @Override
    protected InCmd getInCmd() {
        return new InCmd(StageControllModuleInfo.MODULE_INFO, CommandGroup.GROUP_STAGE, new String[] {StageControllCommands.LOGIN, StageControllCommands.APPLY_CHANGE_LINE, StageControllCommands.CHANGE_STAGE});
    }
    
    protected IEventHandler[] getEventHandlers() {
        return new IEventHandler[] { this.roleLoginHandler, this.roleLogoutHandler };
    }

    @Override
    public void moduleInit() {
        stageControllService.serverStartInitStage();
    }
    
    @Override
    public int getOrder() {
        return 201;
    }
    
}
