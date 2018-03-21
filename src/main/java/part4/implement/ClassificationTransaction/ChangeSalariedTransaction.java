package part4.implement.ClassificationTransaction;

import part4.implement.PayrollDomain.PayrollClassification;
import part4.implement.Classifications.SalariedClassification;
import part4.implement.Schedules.MonthlySchedule;
import part4.implement.PayrollDomain.PayrollSchedule;

/**
 * 직원 임금 변경 (일반)
 */
public class ChangeSalariedTransaction extends ChangeClassificationTransaction {
    private double itsSalary;

    public ChangeSalariedTransaction(int empId, double salary) {
        super(empId);
        this.itsSalary = salary;
    }

    protected PayrollSchedule getSchedule() {
        return new MonthlySchedule();
    }

    protected PayrollClassification getClassification() {
        return new SalariedClassification(itsSalary);
    }
}
