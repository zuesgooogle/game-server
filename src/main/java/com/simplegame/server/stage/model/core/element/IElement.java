package com.simplegame.server.stage.model.core.element;

import com.simplegame.server.stage.model.core.stage.IStageElement;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月16日 下午3:53:43
 *
 */

public interface IElement extends IStageElement {

    public IStateManager getStateManager();
    
}
