package part4.implement.PayrollDomain;

import part4.implement.Payday.PayCheck;

/**
 * 임금 지금방식
 */
public interface PayrollClassification {
    double calculatePay(PayCheck payCheck);
}
