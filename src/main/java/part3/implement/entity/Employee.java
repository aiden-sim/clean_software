package part3.implement.entity;

import part3.implement.affiliation.Affiliation;
import part3.implement.affiliation.NoAffiliation;
import part3.implement.classification.PaymentClassification;
import part3.implement.method.PaymentMethod;
import part3.implement.payday.PayCheck;
import part3.implement.schedule.PaymentSchedule;

import java.util.Date;

/**
 * 직원
 */
public class Employee {
    private int id;
    private String name;
    private String address;

    PaymentMethod itsPaymentMethod;
    PaymentClassification itsClassification;
    Affiliation itsAffiliation;
    PaymentSchedule itsPaymentSchedule;

    public Employee(long id, String name, String address) {
        this.id = (int) id;
        this.name = name;
        this.address = address;
        itsAffiliation = new NoAffiliation();
    }

    public PaymentClassification getClassification() {
        return itsClassification;
    }

    public PaymentSchedule getSchedule() {
        return itsPaymentSchedule;
    }

    public PaymentMethod getMethod() {
        return itsPaymentMethod;
    }

    public void setClassification(PaymentClassification classification) {
        this.itsClassification = classification;
    }

    public void setSchedule(PaymentSchedule paymentSchedule) {
        this.itsPaymentSchedule = paymentSchedule;
    }

    public void setMethod(PaymentMethod paymentMethod) {
        this.itsPaymentMethod = paymentMethod;
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

    public void setItsPaymentMethod(PaymentMethod itsPaymentMethod) {
        this.itsPaymentMethod = itsPaymentMethod;
    }

    public void payDay(PayCheck pc) {
        double grossPay = itsClassification.calculatePay(pc); // 총 급여
        double deductions = itsAffiliation.calculateDeductions(pc); // 공제
        double netPay = grossPay - deductions;
        pc.setGrossPay(grossPay);
        pc.setDetuctions(deductions);
        pc.setNetPay(netPay);
        itsPaymentMethod.pay(pc);
    }

    public boolean isPayDate(Date date) {
        return itsPaymentSchedule.isPayDate(date);
    }

    public Integer getEmpId() {
        return id;
    }

    public Date getPayPeriodSatrtDate(Date date) {
        return itsPaymentSchedule.getPayPeriodStartDate(date);
    }
}
