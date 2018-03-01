package part3.implement.affiliation;


import part3.implement.payday.PayCheck;

/**
 * Created by ZD on 2017/10/24.
 */
public class NoAffiliation implements Affiliation {

    public double calculateDeductions(PayCheck payCheck) {
        return 0;
    }
}
