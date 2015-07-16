package com.simplegame.server.stage.model.core.stage;


/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月16日 下午3:01:41
 *
 */

public interface IStageElement extends IStageElementLifeCycle {

    public abstract String getId();
    
    public abstract String getName();
    
    public abstract String getCamp();
    
    public abstract String getTeamId();
    
    public abstract ElementType getElementType();
    
    public abstract Object getMsgData();
    
    public abstract IStage getStage();
    
    public abstract void setStage(IStage stage);
    
    public abstract void setPosition(int x, int y);
    
    public abstract void setBornPosition(int x, int y);
    
    public abstract Point getPosition();
    
    public abstract Point getBornPosition();
    
}
