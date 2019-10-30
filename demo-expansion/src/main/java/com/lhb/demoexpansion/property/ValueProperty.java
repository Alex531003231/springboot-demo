package com.lhb.demoexpansion.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/10/30  11:34;
 * @description:
 */
@Component
public class ValueProperty {

    @Value("${demo.value-property}")
    private String valueProperty;

    public String getValueProperty() {
        return valueProperty;
    }

    public ValueProperty setValueProperty(String valueProperty) {
        this.valueProperty = valueProperty;
        return this;
    }
}
