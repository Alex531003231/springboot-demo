package com.lhb.demoexpansion.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/10/30  13:47;
 * @description:
 */
@Component
@ConfigurationProperties(prefix = "demo")
public class ConfigurationProperty {

    private String beanProperty1;
    private Boolean beanProperty2;

    public String getBeanProperty1() {
        return beanProperty1;
    }

    public ConfigurationProperty setBeanProperty1(String beanProperty1) {
        this.beanProperty1 = beanProperty1;
        return this;
    }

    public Boolean getBeanProperty2() {
        return beanProperty2;
    }

    public ConfigurationProperty setBeanProperty2(Boolean beanProperty2) {
        this.beanProperty2 = beanProperty2;
        return this;
    }

    @Override
    public String toString() {
        return "ConfigurationProperty{" +
                "beanProperty1='" + beanProperty1 + '\'' +
                ", beanProperty2=" + beanProperty2 +
                '}';
    }
}
