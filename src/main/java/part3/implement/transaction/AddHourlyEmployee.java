package part3.implement.transaction;

import part3.implement.classification.HourlyClassification;
import part3.implement.classification.PaymentClassification;
import part3.implement.schedule.PaymentSchedule;
import part3.implement.schedule.WeeklySchedule;

/**
 * 템플릿 메소드 구현부
 */
public class AddHourlyEmployee extends AddEmployeeTransaction {

    private double hourlyPay;

    public AddHourlyEmployee(int id, String name, String address, double hourlyPay) {
        super(id, name, address);
        this.hourlyPay = hourlyPay;
    }

    protected PaymentSchedule getSchdule() {
        return new WeeklySchedule();
    }

    protected PaymentClassification getClassification() {
        return new HourlyClassification(hourlyPay);
    }
}
