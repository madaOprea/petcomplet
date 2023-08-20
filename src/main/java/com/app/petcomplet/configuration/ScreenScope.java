package com.app.petcomplet.configuration;

import com.app.petcomplet.controller.BaseScreenController;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.*;

import java.util.*;

public class ScreenScope implements Scope {
    private static final Map<String, BaseScreenController> screens = Collections.synchronizedMap(new HashMap<String, BaseScreenController>());

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (!screens.containsKey(name)) {
            screens.put(name, (BaseScreenController)objectFactory.getObject());
        }
        return screens.get(name);
    }

    @Override
    public Object remove(String name) {
        return screens.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        // Unsupported feature
    }

    @Override
    public Object resolveContextualObject(String key) {
        // Unsupported feature
        return null;
    }

    @Override
    public String getConversationId() {
        // Unsupported feature
        return null;
    }

}

