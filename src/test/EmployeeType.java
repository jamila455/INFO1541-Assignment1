
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Custom annotation definition
@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeeType {
    String type();
}
