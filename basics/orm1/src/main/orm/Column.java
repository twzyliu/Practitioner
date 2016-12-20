package orm;

import java.lang.annotation.*;

/**
 * Created by zyongliu on 20/12/16.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    String column() default "";
}
