package main.orm;

import java.lang.annotation.*;

/**
 * Created by zyongliu on 20/12/16.
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AREntity {
    String tableName();
}
