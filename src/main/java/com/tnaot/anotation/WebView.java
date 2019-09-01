package com.tnaot.anotation;


import java.lang.annotation.*;
/**
 * @author Susanna
 * @date 2019/9/1 14:41
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface WebView {
}
