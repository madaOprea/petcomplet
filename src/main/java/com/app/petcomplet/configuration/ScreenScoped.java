package com.app.petcomplet.configuration;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@Scope("screen")
public @interface ScreenScoped {
}


