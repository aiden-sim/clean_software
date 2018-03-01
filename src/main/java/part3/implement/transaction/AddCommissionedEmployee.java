package part3.implement.transaction;

import part3.implement.classification.CommissionedClassification;
import part3.implement.classification.PaymentClassification;
import part3.implement.schedule.BiweeklySchedule;
import part3.implement.schedule.PaymentSchedule;

/**
 * 템플릿 메소드 구현부
 */
public class AddCommissionedEmployee extends AddEmployeeTransaction {

    private double itsSalary;
    private double itsCommissionRate;

    public AddCommissionedEmployee(int id, String name, String address, double salary, double commissionRate) {
        super(id, name, address);
        this.itsCommissionRate = commissionRate;
        this.itsSalary = salary;
    }

    protected PaymentClassification getClassification() {
        return new CommissionedClassification(itsSalary, itsCommissionRate);
    }

    protected PaymentSchedule getSchdule() {
        return new BiweeklySchedule();
    }
}
