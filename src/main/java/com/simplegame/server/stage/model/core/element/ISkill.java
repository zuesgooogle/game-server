package com.simplegame.server.stage.model.core.element;

import com.simplegame.server.bus.skill.configure.export.impl.SkillConfig;
import com.simplegame.server.bus.skill.configure.export.impl.SkillLianConfig;
import com.simplegame.server.gamerule.skill.SkillTargetChooseType;
import com.simplegame.server.stage.model.core.fight.ISkillHatred;
import com.simplegame.server.stage.model.core.fight.ISkillTarget;

public interface ISkill {
    
    public long remainCd();

    public void toCd(IFighter paramIFighter);

    public String getCategory();

    public String getId();

    public ISkillTarget getTarget();

    public Object getHarmEffect();

    public Integer getDynamicCd();

    public ISkillHatred getSkillHatred();

    public SkillLianConfig loadLianZhaoConfigByIndex();

    public void setIndex(int paramInt);

    public boolean hasLianZhao();

    //public void setPublicCdManager(PublicCdManager paramPublicCdManager);

    public SkillTargetChooseType getTargetType();

    public SkillConfig getSkillConfig();
}

/*
 * Location: D:\jd-gui\dntg_start.jar
 * 
 * Qualified Name: com.xianling.stage.model.core.element.ISkill
 * 
 * JD-Core Version: 0.7.0.1
 */