package part3.implement.transaction;

import part3.implement.classification.PaymentClassification;
import part3.implement.classification.SalariedClassification;
import part3.implement.schedule.MonthlySchedule;
import part3.implement.schedule.PaymentSchedule;

/**
 * 직원 임금 변경 (일반)
 */
public class ChangeSalariedTransaction extends ChangeClassificationTransaction {
    private double itsSalary;

    public ChangeSalariedTransaction(int empId, double salary) {
        super(empId);
        this.itsSalary = salary;
    }

    protected PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }

    protected PaymentClassification getClassification() {
        return new SalariedClassification(itsSalary);
    }
}
