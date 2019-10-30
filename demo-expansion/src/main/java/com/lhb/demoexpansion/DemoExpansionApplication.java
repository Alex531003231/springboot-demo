package com.lhb.demoexpansion;

import com.lhb.demoexpansion.property.ConfigurationProperty;
import com.lhb.demoexpansion.property.PropertySourceProperty;
import com.lhb.demoexpansion.property.ValueProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoExpansionApplication {

    private static final Logger logger= LoggerFactory.getLogger(DemoExpansionApplication.class);
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DemoExpansionApplication.class, args);
        // @Value
        logger.info("@Value: {}",applicationContext.getBean(ValueProperty.class).getValueProperty());

        //@ConfigurationProperty
        logger.info("@ConfigurationProperty: {}",applicationContext.getBean(ConfigurationProperty.class));

        //@PropertySource
        logger.info("@PropertySource: {}",applicationContext.getBean(PropertySourceProperty.class).getSourceValue());

    }

}
