package part4.implement.PayrollDomain;

import part4.implement.Payday.PayCheck;

/**
 * 임금 지급 방법
 */
public interface PayrollMethod {
    void pay(PayCheck payCheck);
}
