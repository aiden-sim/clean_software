package part4.implement.ClassificationTransaction;

import part4.implement.Classifications.CommissionedClassification;
import part4.implement.PayrollDomain.PayrollClassification;
import part4.implement.Schedules.BiweeklySchedule;
import part4.implement.PayrollDomain.PayrollSchedule;

/**
 * 직원 임금 변경 (영업)
 */
public class ChangeCommissionedTransaction extends ChangeClassificationTransaction {

    private double salaryBase;
    private double commissionRate;

    public ChangeCommissionedTransaction(int empId, double salaryBase, double commissionRate) {
        super(empId);
        this.commissionRate = commissionRate;
        this.salaryBase = salaryBase;
    }

    protected PayrollSchedule getSchedule() {
        return new BiweeklySchedule();
    }

    protected PayrollClassification getClassification() {
        return new CommissionedClassification(salaryBase, commissionRate);
    }
}
