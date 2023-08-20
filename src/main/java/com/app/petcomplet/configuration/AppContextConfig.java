package com.app.petcomplet.configuration;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.*;

import java.util.*;

@Configuration
@ComponentScan("com.app.petcomplet")
public class AppContextConfig {

    @Bean
    public CustomScopeConfigurer getCustomScopeConfigurer(){
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        final Map<String, Object> scopeMap = new HashMap<>();
        scopeMap.put("screen", screenScope());
        configurer.setScopes(scopeMap);
        return configurer;
    }
    @Bean
    public ScreenScope screenScope(){
        return new ScreenScope();
    }

}
