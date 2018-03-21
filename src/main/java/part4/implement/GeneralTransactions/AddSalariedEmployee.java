package part4.implement.GeneralTransactions;

import part4.implement.PayrollDomain.PayrollClassification;
import part4.implement.Classifications.SalariedClassification;
import part4.implement.Schedules.MonthlySchedule;
import part4.implement.PayrollDomain.PayrollSchedule;

/**
 * 템플릿 메소드 구현부
 */
public class AddSalariedEmployee extends AddEmployeeTransaction {

    private double itsSalary;

    public AddSalariedEmployee(int empId, String name, String address, double salary) {
        super(empId, name, address);
        this.itsSalary = salary;
    }

    protected PayrollClassification getClassification() {
        return new SalariedClassification(itsSalary);
    }

    protected PayrollSchedule getSchdule() {
        return new MonthlySchedule();
    }
}
