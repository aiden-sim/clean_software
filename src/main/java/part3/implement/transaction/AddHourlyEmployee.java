package part3.implement.transaction;

import part3.implement.classification.HourlyClassification;
import part3.implement.classification.PaymentClassification;
import part3.implement.schedule.PaymentSchedule;
import part3.implement.schedule.WeeklySchedule;

/**
 * Created by ZD on 2017/10/24.
 */
public class AddHourlyEmployee extends AddEmployeeTransaction {

    private double hourlyPay;

    public AddHourlyEmployee(long id,String name,String address,double hourlyPay){
        super(id,name,address);
        this.hourlyPay = hourlyPay;
    }

    protected PaymentSchedule getSchdule() {
        return new WeeklySchedule();
    }

    protected PaymentClassification getClassification() {
        return new HourlyClassification(hourlyPay);
    }
}
