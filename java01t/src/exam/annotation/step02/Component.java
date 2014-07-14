package exam.annotation.step02;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
  String[] value();
  String[] url() default "ok";
}
