package com.tnaot.anotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *sourceType指定测试数据源的类型，当前支持Excel和mysql数据库
 *sourcePath指定测试数据的配置文件路径
 *sourceSheetOrSql 当测试数据从Excel读取时，指定sheet名。如果为mysql读取时，指定sql语句
 *mysqlPrefix 当测试数据从mysql读取时，指定数据库前缀
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TargetTestData {

    public String sourceType() default "excel";
    public String sourcePath() default "";
    public String sourceSheetOrSql() default "";
    public String mysqlPrefix() default "test.";
}
