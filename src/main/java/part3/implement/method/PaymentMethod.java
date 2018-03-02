package part3.implement.method;

import part3.implement.payday.PayCheck;

/**
 * 임금 지급 방법
 */
public interface PaymentMethod {
    void pay(PayCheck payCheck);
}
