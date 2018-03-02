package part3.implement.method;

import part3.implement.payday.PayCheck;

/**
 * 임금 지급 방법 (은행)
 */
public class DirectMethod implements PaymentMethod {

    private String bank;
    private double account;


    public DirectMethod(String bank, double account) {
        this.bank = bank;
        this.account = account;
    }

    public DirectMethod(){}


    public void pay(PayCheck payCheck) {
        payCheck.setFields("Diapostion","Direct");
    }
}
