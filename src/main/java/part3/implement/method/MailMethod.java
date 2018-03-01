package part3.implement.method;

import part3.implement.payday.PayCheck;

/**
 * Created by ZD on 2017/10/26.
 */
public class MailMethod implements PaymentMethod {

    private String mailAddress;

    public MailMethod(String mailAdress) {
        this.mailAddress = mailAdress;
    }

    public void pay(PayCheck payCheck) {
        payCheck.setFields("Diapostion","Mail");
    }
}
