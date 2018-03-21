package part4.implement.AffiliationTransactions;


import part4.implement.PayrollDomain.Affiliation;
import part4.implement.TransactionApplication.Transaction;
import part4.implement.Affiliations.UnionAffiliation;
import part4.implement.PayrollDatabase.PayrollDatabase;
import part4.implement.PayrollDomain.Employee;
import part4.implement.Affiliations.ServiceCharge;

import java.util.Date;

/**
 * 조합 공제
 */
public class ServiceChargeTransaction implements Transaction {
    private int itsMemberId;
    private Date itsDate;
    private double itsCharge;

    public ServiceChargeTransaction(int memberId, Date date, double charge) {
        this.itsMemberId = memberId;
        this.itsDate = date;
        this.itsCharge = charge;
    }

    public void execute() {
        Employee e = PayrollDatabase.getPayrollDatabase().getEmployeeByMemberId(itsMemberId);
        Affiliation af = e.getItsAffiliation();
        if (af instanceof UnionAffiliation) {
            ((UnionAffiliation) af).addServiceCharge(new ServiceCharge(itsDate, itsCharge));
        }
    }
}
