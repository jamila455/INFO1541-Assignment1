
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Custom annotation for pay fields
@Retention(RetentionPolicy.RUNTIME)
public @interface PayRate {
    String type();
}
