package com.simplegame.server.stage.model.core.element.impl.attribute;

import com.simplegame.server.gamerule.attribute.EffectType;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年7月24日 上午11:40:52
 *
 */

public class EffectAttribute extends AbsBaseAttribute {

    @Override
    public void attributeCheck(String attr) {
        EffectType.contains(attr);
    }

}
