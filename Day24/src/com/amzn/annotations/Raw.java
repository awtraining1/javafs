package com.amzn.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// Fruits that can be eaten raw
@Target({ElementType.TYPE})
public @interface Raw {

}
