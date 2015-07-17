package com.simplegame.server.stage.modelinit;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.core.data.accessor.cache.IEntityCacheModelLoader;
import com.simplegame.core.event.IEventHandler;
import com.simplegame.server.stage.StageModuleInfo;
import com.simplegame.server.stage.dao.cache.RoleStageCacheModelLoader;
import com.simplegame.server.stage.event.subscribe.StageRoleCreateHandler;
import com.simplegame.server.stage.event.subscribe.StageRoleLogoutHandler;
import com.simplegame.server.stage.service.IStageService;
import com.simplegame.server.stage.share.moduleinit.AbsStageModuleInit;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月17日 下午3:40:59
 *
 */
@Component
public class StageModuleInit extends AbsStageModuleInit {

    @Resource
    private RoleStageCacheModelLoader roleStageCacheModelLoader;
    
    @Resource
    private StageRoleCreateHandler stageRoleCreateHandler;
   
    @Resource
    private StageRoleLogoutHandler stageRoleLogoutHandler;
    
    @Resource
    private IStageService stageService;
    
    @Override
    protected InCmd getInCmd() {
        return new InCmd(StageModuleInfo.MODULE_NAME, StageModuleInfo.MODULE_NAME_ABBR, new String[]{});
    }

    protected IEntityCacheModelLoader[] getEntityCacheModelLoaders() {
        return new IEntityCacheModelLoader[] { this.roleStageCacheModelLoader };
    }
    
    protected IEventHandler[] getEventHandlers() {
        return new IEventHandler[] { this.stageRoleCreateHandler, this.stageRoleLogoutHandler };
    }
    
    
}
