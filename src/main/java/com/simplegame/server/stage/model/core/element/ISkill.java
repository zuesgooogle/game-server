package com.simplegame.server.stage.model.core.element;

import com.simplegame.server.bus.skill.configure.export.impl.SkillConfig;
import com.simplegame.server.bus.skill.configure.export.impl.SkillLianConfig;
import com.simplegame.server.gamerule.skill.SkillTargetChooseType;
import com.simplegame.server.stage.model.core.element.impl.skill.PublicCdManager;
import com.simplegame.server.stage.model.core.fight.ISkillHatred;
import com.simplegame.server.stage.model.core.fight.ISkillTarget;

public interface ISkill {
    
    public long remainCd();

    public void toCd(IFighter fighter);

    public String getCategory();

    public String getId();

    public ISkillTarget getTarget();

    public Object getHarmEffect();

    public Integer getDynamicCd();

    public ISkillHatred getSkillHatred();

    public SkillLianConfig loadLianZhaoConfigByIndex();

    public void setIndex(int index);

    public boolean hasLianZhao();

    public void setPublicCdManager(PublicCdManager publicCdManager);

    public SkillTargetChooseType getTargetType();

    public SkillConfig getSkillConfig();
}