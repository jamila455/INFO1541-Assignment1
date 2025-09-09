
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationInspector {
    public static void main(String[] args) throws Exception {

        // Part 2 objects
        HourlyEmployee hourly = new HourlyEmployee("Tony", "Stark", 5749, "Service", "Lead Service Manager", 32.85);
        SalaryEmployee salary = new SalaryEmployee("Steve", "Rodgers", 3781, "Sales", "Manager", 64325);
        CommissionEmployee commission = new CommissionEmployee("Clint", "Barton", 6847, "Sales", "Customer Representative", 0.0265);

        Object[] employees = {hourly, salary, commission};

        // Count how many employees have EmployeeType annotation
        int annotatedCount = 0;
        for (Object emp : employees) {
            if (emp.getClass().isAnnotationPresent(EmployeeType.class)) {
                annotatedCount++;
            }
        }
        System.out.println("You have " + annotatedCount + " employee types"); // should print 3

        // Loop through each employee to inspect fields and methods
        for (Object emp : employees) {
            Class<?> cls = emp.getClass();

            // Check fields for PayRate annotation
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(PayRate.class)) {
                    field.setAccessible(true);
                    Object value = field.get(emp);
                    System.out.println("Employee pay rate: $" + value);
                }
            }

            // Check methods for WeeklyPayCalculator annotation
            for (Method method : cls.getDeclaredMethods()) {
                if (method.isAnnotationPresent(WeeklyPayCalculator.class)) {
                    Object result = method.invoke(emp);
                    System.out.println("Weekly pay calculated: $" + result);
                }
            }

            System.out.println("-----"); // separator between employees
        }
    }
}
