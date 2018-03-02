package part3.implement.affiliation;


import part3.implement.payday.PayCheck;

/**
 * 조합없음
 */
public class NoAffiliation implements Affiliation {

    public double calculateDeductions(PayCheck payCheck) {
        return 0;
    }
}
