package part4.implement.PayrollDomain;

import part4.implement.Affiliations.NoAffiliation;
import part4.implement.Payday.PayCheck;

import java.util.Date;

/**
 * 직원
 */
public class Employee {
    private int id;
    private String name;
    private String address;

    PayrollMethod itsPayrollMethod;
    PayrollClassification itsClassification;
    Affiliation itsAffiliation;
    PayrollSchedule itsPayrollSchedule;

    public Employee(long id, String name, String address) {
        this.id = (int) id;
        this.name = name;
        this.address = address;
        itsAffiliation = new NoAffiliation();
    }

    public PayrollClassification getClassification() {
        return itsClassification;
    }

    public PayrollSchedule getSchedule() {
        return itsPayrollSchedule;
    }

    public PayrollMethod getMethod() {
        return itsPayrollMethod;
    }

    public void setClassification(PayrollClassification classification) {
        this.itsClassification = classification;
    }

    public void setSchedule(PayrollSchedule payrollSchedule) {
        this.itsPayrollSchedule = payrollSchedule;
    }

    public void setMethod(PayrollMethod payrollMethod) {
        this.itsPayrollMethod = payrollMethod;
    }

    public void setItsAffiliation(Affiliation affiliation) {
        this.itsAffiliation = affiliation;
    }

    public Affiliation getItsAffiliation() {
        return itsAffiliation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setItsPayrollMethod(PayrollMethod itsPayrollMethod) {
        this.itsPayrollMethod = itsPayrollMethod;
    }

    public void payDay(PayCheck pc) {
        double grossPay = itsClassification.calculatePay(pc); // 총 급여
        double deductions = itsAffiliation.calculateDeductions(pc); // 공제
        double netPay = grossPay - deductions;
        pc.setGrossPay(grossPay);
        pc.setDetuctions(deductions);
        pc.setNetPay(netPay);
        itsPayrollMethod.pay(pc);
    }

    public boolean isPayDate(Date date) {
        return itsPayrollSchedule.isPayDate(date);
    }

    public Integer getEmpId() {
        return id;
    }

    public Date getPayPeriodSatrtDate(Date date) {
        return itsPayrollSchedule.getPayPeriodStartDate(date);
    }
}
