package part3.implement.method;

import part3.implement.payday.PayCheck;

/**
 * 임금 지급 방법 (직접 수령)
 */
public class HoldMethod implements PaymentMethod {
    public void pay(PayCheck payCheck) {
        payCheck.setFields("Diapostion","Hold");
    }
}
