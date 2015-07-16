package com.simplegame.server.stage.model.core.fight;

import com.simplegame.server.gamerule.skill.SkillTargetChooseType;
import com.simplegame.server.stage.model.core.element.IFighter;
import com.simplegame.server.stage.model.core.element.ISkill;

public interface ISkillTarget {
    
    public boolean inRange(ISkill skill, IFighter fighter1, IFighter fighter2);

    public SkillTargetChooseType getTargetChooseType();
}
