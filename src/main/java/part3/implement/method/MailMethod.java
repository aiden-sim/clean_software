package part3.implement.method;

import part3.implement.payday.PayCheck;

/**
 * 임금 지급 방법 (우편 발송)
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
