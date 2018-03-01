package part3.chapter19;

import part3.chapter19.classification.PaymentClassification;
import part3.chapter19.classification.SalariedClassification;
import part3.chapter19.payschedule.MonthlySchedule;
import part3.chapter19.payschedule.PaymentSchedule;

public class AddSalariedEmployee extends AddEmployeeTransaction {

    private double itsSalary;

    public AddSalariedEmployee(int empid, String name, String address, double salary) {
        super(empid, name, address);
        this.itsSalary = salary;
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }

    @Override
    public PaymentClassification getClassfication() {
        return new SalariedClassification(itsSalary);
    }
}
