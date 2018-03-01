package part3.chapter19;

import part3.chapter19.classification.PaymentClassification;
import part3.chapter19.payschedule.PaymentSchedule;

public class Employee {
    private int id;
    private String name;
    private String address;
    private PaymentSchedule paymentSchedule;
    private PaymentMethod paymentMethod;
    private PaymentClassification paymentClassfication;
    private Affiliation affiliation;

    public Employee(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public PaymentSchedule getPaymentSchedule() {
        return paymentSchedule;
    }

    public void setPaymentSchedule(PaymentSchedule paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentClassification getPaymentClassfication() {
        return paymentClassfication;
    }

    public void setPaymentClassfication(
        PaymentClassification paymentClassfication) {
        this.paymentClassfication = paymentClassfication;
    }

    public void setAffilication(Affiliation affiliations) {
        this.affiliation = affiliations;
    }

    public Affiliation getAffiliation() {
        return affiliation;
    }
}
