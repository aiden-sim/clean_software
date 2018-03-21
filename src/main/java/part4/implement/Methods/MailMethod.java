package part4.implement.Methods;

import part4.implement.PayrollDomain.PayrollMethod;
import part4.implement.Payday.PayCheck;

/**
 * 임금 지급 방법 (우편 발송)
 */
public class MailMethod implements PayrollMethod {

    private String mailAddress;

    public MailMethod(String mailAdress) {
        this.mailAddress = mailAdress;
    }

    public void pay(PayCheck payCheck) {
        payCheck.setFields("Diapostion","Mail");
    }
}
