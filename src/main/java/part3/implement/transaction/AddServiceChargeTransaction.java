package part3.implement.transaction;


import part3.implement.affiliation.Affiliation;
import part3.implement.affiliation.UnionAffiliation;
import part3.implement.database.PayrollDatabase;
import part3.implement.entity.Employee;
import part3.implement.entity.ServiceCharge;

import java.util.Date;

/**
 * Created by ZD on 2017/10/24.
 */
public class AddServiceChargeTransaction implements Transaction {

    private long memberId;
    private Date date;
    private double amount;


    public AddServiceChargeTransaction(){}

    public AddServiceChargeTransaction(long memberId, Date date, double amount){
        this.memberId = memberId;
        this.date = date;
        this.amount = amount;
    }

    public void execute() {
        Employee e = PayrollDatabase.getPayrollDatabase().getEmployeeByMemberId(memberId);
        ServiceCharge charge = new ServiceCharge(date,amount);

        Affiliation affiliation = e.getAffiliation();
        if (affiliation instanceof UnionAffiliation){
            ((UnionAffiliation)affiliation).addServiceCharge(new ServiceCharge(date,amount));
        }
    }
}
