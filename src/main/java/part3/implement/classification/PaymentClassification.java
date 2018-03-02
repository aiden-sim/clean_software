package part3.implement.classification;

import part3.implement.payday.PayCheck;

/**
 * 임금 지금방식
 */
public interface PaymentClassification {
    double calculatePay(PayCheck payCheck);
}
