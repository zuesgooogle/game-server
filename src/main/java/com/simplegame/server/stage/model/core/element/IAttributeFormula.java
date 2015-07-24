package com.simplegame.server.stage.model.core.element;

import com.simplegame.server.stage.model.core.element.impl.attribute.AbsFightAttribute;
import com.simplegame.server.stage.model.core.element.impl.attribute.FightAttributeWriter;

public interface IAttributeFormula {
    
    public void refreshAttribute(AbsFightAttribute fightAttribute, FightAttributeWriter fightAttributeWriter);

    public void addRelateFormula(IAttributeFormula attributeFormula);
}
