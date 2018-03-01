package part3.implement.method;

import part3.implement.payday.PayCheck;

/**
 * Created by ZD on 2017/10/24.
 */
public class HoldMethod implements PaymentMethod {
    public void pay(PayCheck payCheck) {
        payCheck.setFields("Diapostion","Hold");
    }
}
