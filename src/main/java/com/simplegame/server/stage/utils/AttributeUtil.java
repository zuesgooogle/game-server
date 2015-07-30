package com.simplegame.server.stage.utils;

import java.util.Map;

import com.simplegame.server.stage.model.core.element.BaseAttributeType;
import com.simplegame.server.stage.model.core.element.IFighter;

public class AttributeUtil {
    
    public static void incrBuffAttribute(IFighter fighter, Map<String, Float> attributes) {
        fighter.getFightAttribute().incrBaseAttribute(BaseAttributeType.EFFECT, attributes);
    }

    public static void decrBuffAttribute(IFighter fighter, Map<String, Float> attributes) {
        fighter.getFightAttribute().descBaseAttribute(BaseAttributeType.EFFECT, attributes);
    }
}
