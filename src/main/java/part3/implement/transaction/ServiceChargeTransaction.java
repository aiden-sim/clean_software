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
