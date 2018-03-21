package part4.implement.GeneralTransactions;

import part4.implement.Classifications.HourlyClassification;
import part4.implement.PayrollDomain.PayrollClassification;
import part4.implement.PayrollDomain.PayrollSchedule;
import part4.implement.Schedules.WeeklySchedule;

/**
 * 템플릿 메소드 구현부
 */
public class AddHourlyEmployee extends AddEmployeeTransaction {

    private double hourlyPay;

    public AddHourlyEmployee(int id, String name, String address, double hourlyPay) {
        super(id, name, address);
        this.hourlyPay = hourlyPay;
    }

    protected PayrollSchedule getSchdule() {
        return new WeeklySchedule();
    }

    protected PayrollClassification getClassification() {
        return new HourlyClassification(hourlyPay);
    }
}
