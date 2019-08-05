package Dynamic01;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface House {
    int price() default 0;
    String name() default "MESA";
}
