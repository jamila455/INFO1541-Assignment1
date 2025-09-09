
// HourlyEmployeeTest.java
// This file contains unit tests for the HourlyEmployee class
// Written by [Your Name]

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@EmployeeType(type = "Hourly")
public class HourlyEmployeeTest {

    @WeeklyPayCalculator
    public double calculateWeeklyPay() {
    }


    @PayRate(type = "Hourly")
    private HourlyEmployee emp;  // we will reuse this test employee

    // This method runs before each test so we always start fresh
    @BeforeEach
    public void setUp() {
        emp = new HourlyEmployee("Tony", "Stark", 5749,
                "Service", "Lead Service Manager", 32.85);
    }

    // Test that positive hours are added correctly
    @Test
    public void testIncreaseHours_AddPositiveHours() {
        emp.increaseHours(10);   // add 10 hours
        emp.increaseHours(5);    // add 5 more hours
        assertEquals(15, emp.getHoursWorked(),
                "Total hours should be 15 after adding 10 and 5");
    }

    // Test that negative hours do not get added
    @Test
    public void testIncreaseHours_AddNegativeHours() {
        emp.increaseHours(10);   // add 10 hours
        emp.increaseHours(-5);   // try to add negative hours (should be ignored)
        assertEquals(10, emp.getHoursWorked(),
                "Negative hours should not change the total worked hours");
    }

    // Test that the annualRaise method increases wage by 5%
    @Test
    public void testAnnualRaise() {
        emp.annualRaise();  // should increase wage by 5%
        assertEquals(34.49, emp.getWage(), 0.01,
                "Wage should be 34.49 after 5% raise from 32.85");
    }

    // Test weekly pay calculation for 35 hours (no overtime)
    @Test
    public void testCalculateWeeklyPay_NoOvertime() {
        emp.increaseHours(35);   // worked 35 hours
        double pay = emp.calculateWeeklyPay();
        assertEquals(1149.75, pay, 0.01,
                "Weekly pay should be 1149.75 for 35 hours at 32.85/hr");
    }

    // Test weekly pay calculation for 45 hours (with overtime)
    @Test
    public void testCalculateWeeklyPay_WithOvertime() {
        emp.increaseHours(45);   // worked 45 hours
        double pay = emp.calculateWeeklyPay();
        assertEquals(1560.38, pay, 0.01,
                "Weekly pay should be 1560.38 for 45 hours including overtime");
    }
}
