
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommissionEmployeeTest {

    // Fake employee to use for testing
    CommissionEmployee emp = new CommissionEmployee(
            "Clint", "Barton", 6847,
            "Sales", "Customer Representative", 0.0265);

    @Test
    public void testIncreaseSales() {
        // Add positive sales
        emp.increaseSales(4000);
        // Try to add negative sales (should NOT be added)
        emp.increaseSales(-1500);
        // Add more positive sales
        emp.increaseSales(2000);

        // Expected total sales = 4000 + 2000 = 6000
        double expected = 6000.0;
        double actual = emp.getSales();

        assertEquals(expected, actual, 0.01,
                "Sales should only increase with positive values");
    }

    @Test
    public void testHolidayBonus() {
        double expected = 0.0;
        double actual = emp.holidayBonus();

        assertEquals(expected, actual, 0.01,
                "Commission employees should not get a holiday bonus");
    }

    @Test
    public void testAnnualRaise() {
        // Call raise twice
        emp.annualRaise();
        emp.annualRaise();

        // Expected rate = 0.0265 + 0.002 + 0.002 = 0.0305
        double expected = 0.0305;
        double actual = emp.getRate();

        assertEquals(expected, actual, 0.0001,
                "Rate should increase correctly after two raises");
    }
}
