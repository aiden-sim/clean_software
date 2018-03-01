package part3.implement.classification;

import part3.implement.payday.PayCheck;

/**
 * Created by ZD on 2017/10/24.
 */
public class SalariedClassification implements PaymentClassification {

    private double itsSalary;

    public SalariedClassification(double salary) {
        this.itsSalary = salary;
    }

    public double getMonthlyPay() {
        return itsSalary;
    }

    public double calculatePay(PayCheck payCheck) {
        return itsSalary;
    }
}
