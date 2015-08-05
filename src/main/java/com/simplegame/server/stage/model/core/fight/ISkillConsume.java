package com.simplegame.server.stage.model.core.fight;

import com.simplegame.server.stage.model.core.element.IFighter;
import com.simplegame.server.stage.model.core.element.ISkill;

public interface ISkillConsume {
    
    /**
     * 执行消耗处理
     * 
     * @param fighter
     * @param skill
     * @return
     */
    
    public Object execute(IFighter fighter, ISkill skill);

    /**
     * 是否满足条件
     * 
     * @param fighter
     * @param skill
     * @return
     */
    public boolean isEnough(IFighter fighter, ISkill skill);
}
