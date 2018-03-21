package part4.implement.GeneralTransactions;

import part4.implement.Classifications.CommissionedClassification;
import part4.implement.PayrollDomain.PayrollClassification;
import part4.implement.Schedules.BiweeklySchedule;
import part4.implement.PayrollDomain.PayrollSchedule;

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

    protected PayrollClassification getClassification() {
        return new CommissionedClassification(itsSalary, itsCommissionRate);
    }

    protected PayrollSchedule getSchdule() {
        return new BiweeklySchedule();
    }
}
