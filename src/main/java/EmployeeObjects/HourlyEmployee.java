package EmployeeObjects;

import EmployeeAnnotations.EmployeeType;
import EmployeeAnnotations.PayRate;
import EmployeeAnnotations.WeeklyPayCalculator;
import EmployeeBlueprints.Employee;

@EmployeeType(type = "Hourly")
public class HourlyEmployee extends Employee {
    @PayRate(type = "Hourly")
    private double wage;

    public HourlyEmployee(String tony, String stark, int i, String service, String leadServiceManager, double v) {

    }

    @WeeklyPayCalculator
    public double calculateWeeklyPay() {

        return 0;
    }

    @Override
    public void resetWeek() {

    }

    @Override
    public void annualRaise() {

    }

    @Override
    public double holidayBonus() {
        return 0;
    }

    @Override
    public void setPay(double pay) {

    }

    public void increaseHours(double hoursToAdd) {

    }
}
