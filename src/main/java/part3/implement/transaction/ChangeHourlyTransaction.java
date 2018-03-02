package part3.implement.transaction;

import part3.implement.classification.HourlyClassification;
import part3.implement.classification.PaymentClassification;
import part3.implement.schedule.PaymentSchedule;
import part3.implement.schedule.WeeklySchedule;

/**
 * 직원 임금 변경 (알바)
 */
public class ChangeHourlyTransaction extends ChangeClassificationTransaction {
    private double itsHourlyRate;

    public ChangeHourlyTransaction(int empId, double hourlyRate) {
        super(empId);
        this.itsHourlyRate = hourlyRate;
    }

    public PaymentSchedule getSchedule() {
        return new WeeklySchedule();
    }

    public PaymentClassification getClassification() {
        return new HourlyClassification(itsHourlyRate);
    }
}
