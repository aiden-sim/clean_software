package part4.implement.Methods;

import part4.implement.PayrollDomain.PayrollMethod;
import part4.implement.Payday.PayCheck;

/**
 * 임금 지급 방법 (은행)
 */
public class DirectMethod implements PayrollMethod {

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
