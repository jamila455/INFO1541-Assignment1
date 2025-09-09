
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SalaryEmployeeTest {

    // Create a fake employee to test with
    SalaryEmployee emp = new SalaryEmployee("Steve", "Rodgers", 3781, "Sales", "Manager", 64325);

    @Test
    public void testCalculateWeeklyPay() {
        // Expected weekly pay: salary / 52
        // 64325 / 52 = 1237.019... → rounded to 1237.02
        double expected = 1237.02;
        double actual = emp.calculateWeeklyPay();
        assertEquals(expected, actual, 0.01, "Weekly pay calculation is incorrect!");
    }

    @Test
    public void testHolidayBonus() {
        // Expected holiday bonus: 3.365% of salary
        // 64325 * 0.03365 = 2164.543625 → rounded to 2164.54
        double expected = 2164.54;
        double actual = emp.holidayBonus();
        assertEquals(expected, actual, 0.01, "Holiday bonus calculation is incorrect!");
    }
}
