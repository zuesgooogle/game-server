package com.simplegame.server.stage.model.core.fight;

import com.simplegame.server.stage.model.core.element.IFighter;
import com.simplegame.server.stage.model.core.element.ISkill;
import com.simplegame.server.stage.model.fight.HarmType;

public interface IHarm {
    
    public HarmType getType();

    public int getVal();

    public IFighter getAttacker();

    public IFighter getTarget();

    public ISkill getSkill();
}