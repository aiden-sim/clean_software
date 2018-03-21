package part4.implement.Methods;

import part4.implement.PayrollDomain.PayrollMethod;
import part4.implement.Payday.PayCheck;

/**
 * 임금 지급 방법 (직접 수령)
 */
public class HoldMethod implements PayrollMethod {
    public void pay(PayCheck payCheck) {
        payCheck.setFields("Diapostion","Hold");
    }
}
