package com.simplegame.server.stage.model.core.element;

import java.util.Collection;
import java.util.List;

public abstract interface ISkillManager
{
  public abstract void addSkill(ISkill paramISkill);
  
  public abstract void removeSkill(String paramString);
  
  public abstract ISkill getSkillByCategory(String paramString);
  
  public abstract ISkill getSkillById(String paramString);
  
  public abstract boolean isReadyForFire(ISkill paramISkill);
  
  public abstract void setReadyForFire(ISkill paramISkill);
  
  public abstract boolean skillWaveCheck(ISkill paramISkill);
  
  public abstract long getRemainCd();
  
  public abstract Collection<ISkill> getSkillList();
  
  public abstract ISkill getNextUseableSkill();
  
  public abstract ISkill getNextFireSkill();
  
  public abstract void setNextFireSkill(ISkill paramISkill);
  
  public abstract List<String> getSkillIds();
  
  public abstract List<String> getSkillMonsterIds();
  
  public abstract void addSkillMonsterIds(String paramString);
  
  public abstract void removeSkillCallMonster(String paramString);
  
  public abstract Object[] getConfigSkillIds();
  
  public abstract void addShenqiSkill(String paramString, Float paramFloat, int paramInt, float paramFloat1, long paramLong);
  
  public abstract ISkill randomShenQiSkill();
  
  public abstract void removeShenQiSkill(String paramString, int paramInt);
}


/* Location:           D:\jd-gui\dntg_start.jar
 * Qualified Name:     com.xianling.stage.model.core.element.ISkillManager
 * JD-Core Version:    0.7.0.1
 */