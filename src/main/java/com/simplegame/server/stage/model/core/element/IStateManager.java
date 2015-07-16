package com.simplegame.server.stage.model.core.element;

import com.simplegame.server.stage.model.core.element.impl.state.StateEventType;
import com.simplegame.server.stage.model.core.element.impl.state.StateStatistic;
import com.simplegame.server.stage.model.core.element.impl.state.StateType;


/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年7月16日 下午3:54:57
 * 
 */

public interface IStateManager extends IElementComponent {

    public abstract void add(IState paramIState);

    public abstract IState getState(StateType paramStateType);

    public abstract boolean remove(StateType paramStateType);

    public abstract IState remove2(StateType paramStateType);

    public abstract boolean isForbidden(StateEventType paramStateEventType);

    public abstract boolean contains(StateType paramStateType);

    public abstract boolean isDead();

    public abstract Integer getClientState();

    public abstract void clear();

    public abstract StateStatistic getStateStatistic();

}
