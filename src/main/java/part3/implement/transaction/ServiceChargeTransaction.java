package part3.implement.transaction;


import part3.implement.affiliation.Affiliation;
import part3.implement.affiliation.UnionAffiliation;
import part3.implement.database.PayrollDatabase;
import part3.implement.entity.Employee;
import part3.implement.entity.ServiceCharge;

import java.util.Date;

/**
 * 조합 공제
 */
public class ServiceChargeTransaction implements Transaction {
    private int itsMemberId;
    private Date itsDate;
    private double itsAmount;

    public ServiceChargeTransaction(int memberId, Date date, double amount) {
        this.itsMemberId = memberId;
        this.itsDate = date;
        this.itsAmount = amount;
    }

    public void execute() {
        Employee e = PayrollDatabase.getPayrollDatabase().getEmployeeByMemberId(itsMemberId);
        Affiliation af = e.getAffiliation();
        if (af instanceof UnionAffiliation) {
            ((UnionAffiliation) af).addServiceCharge(new ServiceCharge(itsDate, itsAmount));
        }
    }
}
