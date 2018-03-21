package part4.implement.Affiliations;


import part4.implement.PayrollDomain.Affiliation;
import part4.implement.Payday.PayCheck;

/**
 * 조합없음
 */
public class NoAffiliation implements Affiliation {

    public double calculateDeductions(PayCheck payCheck) {
        return 0;
    }
}
