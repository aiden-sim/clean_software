package part3.implement.transaction;

import part3.implement.classification.HourlyClassification;
import part3.implement.classification.PaymentClassification;
import part3.implement.schedule.PaymentSchedule;
import part3.implement.schedule.WeeklySchedule;

/**
 * Created by ZD on 2017/10/25.
 */
public class ChangeHourlyTransaction extends ChangeClassificationTransaction {

    private double hourlyRate;

    public ChangeHourlyTransaction(){}

    public ChangeHourlyTransaction(long empId,double hourlyRate){
        super((int) empId);
        this.hourlyRate = hourlyRate;
    }

    public PaymentSchedule getSchedule(){
        return new WeeklySchedule();
    }

    public PaymentClassification getClassification(){
        return new HourlyClassification(hourlyRate);
    }
}
