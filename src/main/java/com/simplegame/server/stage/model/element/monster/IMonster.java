package com.simplegame.server.stage.model.element.monster;

import com.simplegame.server.stage.configure.export.impl.MonsterConfig;
import com.simplegame.server.stage.model.core.element.IFighter;

public interface IMonster extends IFighter {
    
    public String getMonsterId();

    public boolean isBoss();

    public MonsterConfig getMonsterConfig();

    //public IRole getBenefitRole();

    public String[] getBenefitRoleIds();

    //public SummonManager getSummonAiManager();

    //public MonsterSpeakManager getSpeakManager();

    public long getEnterFightStateTime();

    public void setEnterFightStateTime(long stateTime);
}