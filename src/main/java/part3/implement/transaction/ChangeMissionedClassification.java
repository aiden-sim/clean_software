package part3.implement.transaction;

import part3.implement.classification.CommissionedClassification;
import part3.implement.classification.PaymentClassification;
import part3.implement.schedule.BiweeklySchedule;
import part3.implement.schedule.PaymentSchedule;

/**
 * Created by ZD on 2017/10/25.
 */
public class ChangeMissionedClassification extends ChangeClassificationTransaction {

    private double salaryBase;
    private double commissionRate;

    public ChangeMissionedClassification(){}

    public ChangeMissionedClassification(long empId,double salaryBase,double commissionRate){
        super((int) empId);
        this.commissionRate = commissionRate;
        this.salaryBase = salaryBase;
    }

    protected PaymentSchedule getSchedule() {
        return new BiweeklySchedule();
    }

    protected PaymentClassification getClassification() {
        return new CommissionedClassification(salaryBase,commissionRate);
    }
}
