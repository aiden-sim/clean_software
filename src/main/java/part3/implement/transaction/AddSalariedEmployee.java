package part3.implement.transaction;

import part3.implement.classification.PaymentClassification;
import part3.implement.classification.SalariedClassification;
import part3.implement.schedule.MonthlySchedule;
import part3.implement.schedule.PaymentSchedule;

/**
 * 派生自AddEmployeeTransaction
 * Created by ZD on 2017/10/24.
 */
public class AddSalariedEmployee extends AddEmployeeTransaction {

    private double monthlyPay;

    public AddSalariedEmployee(long id,String name,String address,double monthlyPay){
        super(id,name,address);
        this.monthlyPay = monthlyPay;
    }

    protected PaymentSchedule getSchdule() {
        return new MonthlySchedule();
    }

    protected PaymentClassification getClassification() {
        return new SalariedClassification(monthlyPay);
    }
}
