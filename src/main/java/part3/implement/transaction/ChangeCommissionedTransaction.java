package part3.implement.transaction;

import part3.implement.classification.CommissionedClassification;
import part3.implement.classification.PaymentClassification;
import part3.implement.schedule.BiweeklySchedule;
import part3.implement.schedule.PaymentSchedule;

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

    protected PaymentSchedule getSchedule() {
        return new BiweeklySchedule();
    }

    protected PaymentClassification getClassification() {
        return new CommissionedClassification(salaryBase, commissionRate);
    }
}
