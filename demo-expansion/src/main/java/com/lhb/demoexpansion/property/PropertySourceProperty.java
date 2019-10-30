package com.lhb.demoexpansion.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/10/30  14:15;
 * @description:
 */
@Component
@PropertySource("classpath:demo.properties")
public class PropertySourceProperty {

    @Value("${demo.property-source-property:}")
    private String sourceValue;

    public String getSourceValue() {
        return sourceValue;
    }

    public PropertySourceProperty setSourceValue(String sourceValue) {
        this.sourceValue = sourceValue;
        return this;
    }
}
