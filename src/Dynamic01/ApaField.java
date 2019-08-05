package Dynamic01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApaField {
    String columnName() default "";
    String type() default "";
    int size() default 10;
}
