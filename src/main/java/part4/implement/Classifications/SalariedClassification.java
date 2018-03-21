package part4.implement.Classifications;

import part4.implement.PayrollDomain.PayrollClassification;
import part4.implement.Payday.PayCheck;

/**
 * 임금 지금방식 (일반)
 */
public class SalariedClassification implements PayrollClassification {

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
