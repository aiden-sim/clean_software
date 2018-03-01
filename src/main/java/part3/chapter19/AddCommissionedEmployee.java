package part3.chapter19;

import part3.chapter19.classification.CommissionedClassification;
import part3.chapter19.classification.PaymentClassification;
import part3.chapter19.payschedule.BiWeeklySchedule;
import part3.chapter19.payschedule.PaymentSchedule;

public class AddCommissionedEmployee extends AddEmployeeTransaction {

    private double salary;
    private double commissionRate;

    public AddCommissionedEmployee(int itsEmpid, String itsName, String itsAddress, double salary,
        double commissionRate) {
        super(itsEmpid, itsName, itsAddress);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new BiWeeklySchedule();
    }

    @Override
    public PaymentClassification getClassfication() {
        return new CommissionedClassification(salary, commissionRate);
    }
}
