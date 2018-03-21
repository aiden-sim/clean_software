package part4.implement.PayrollDomain;


import part4.implement.Payday.PayCheck;

/**
 * 조합
 */
public interface Affiliation {
    double calculateDeductions(PayCheck payCheck);
}
