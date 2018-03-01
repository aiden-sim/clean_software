package part3.implement.transaction;

import part3.implement.classification.PaymentClassification;
import part3.implement.classification.SalariedClassification;
import part3.implement.schedule.MonthlySchedule;
import part3.implement.schedule.PaymentSchedule;

/**
 * 템플릿 메소드 구현부
 */
public class AddSalariedEmployee extends AddEmployeeTransaction {

    private double itsSalary;

    public AddSalariedEmployee(int empId, String name, String address, double salary) {
        super(empId, name, address);
        this.itsSalary = salary;
    }

    protected PaymentClassification getClassification() {
        return new SalariedClassification(itsSalary);
    }

    protected PaymentSchedule getSchdule() {
        return new MonthlySchedule();
    }
}
