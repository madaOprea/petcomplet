package com.app.petcomplet.constraints;

import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Documented
@NotNull
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, TYPE_USE})
public @interface PriceLimit {

    String message() default "{com.petcomplet.constraints.PriceLimit.message}";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
