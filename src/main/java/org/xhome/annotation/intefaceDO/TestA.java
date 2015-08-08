package org.xhome.annotation.intefaceDO;

import java.lang.annotation.*;
@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestA {
	int value() default 0;
}
