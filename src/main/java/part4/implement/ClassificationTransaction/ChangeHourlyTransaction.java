package part4.implement.ClassificationTransaction;

import part4.implement.Classifications.HourlyClassification;
import part4.implement.PayrollDomain.PayrollClassification;
import part4.implement.PayrollDomain.PayrollSchedule;
import part4.implement.Schedules.WeeklySchedule;

/**
 * 직원 임금 변경 (알바)
 */
public class ChangeHourlyTransaction extends ChangeClassificationTransaction {
    private double itsHourlyRate;

    public ChangeHourlyTransaction(int empId, double hourlyRate) {
        super(empId);
        this.itsHourlyRate = hourlyRate;
    }

    public PayrollSchedule getSchedule() {
        return new WeeklySchedule();
    }

    public PayrollClassification getClassification() {
        return new HourlyClassification(itsHourlyRate);
    }
}
