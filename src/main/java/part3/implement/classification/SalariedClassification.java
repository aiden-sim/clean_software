package part3.implement.classification;

import part3.implement.payday.PayCheck;

/**
 * 임금 지금방식 (일반)
 */
public class SalariedClassification implements PaymentClassification {

    private double itsSalary;

    public SalariedClassification(double salary) {
        this.itsSalary = salary;
    }

    public double getSalary() {
        return itsSalary;
    }

    public double calculatePay(PayCheck payCheck) {
        return itsSalary;
    }
}
