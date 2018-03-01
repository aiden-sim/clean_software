package part3.implement.transaction;

import part3.implement.affiliation.Affiliation;
import part3.implement.affiliation.NoAffiliation;
import part3.implement.affiliation.UnionAffiliation;
import part3.implement.database.PayrollDatabase;
import part3.implement.entity.Employee;

/**
 * Created by ZD on 2017/10/26.
 */
public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {

    public ChangeUnaffiliatedTransaction(){}

    public ChangeUnaffiliatedTransaction(int empId){
        super(empId);
    }

    protected NoAffiliation getAffiliation() {
        return new NoAffiliation();
    }

    protected void recordMemberShip(Employee e) {
        UnionAffiliation unionAffiliation = (UnionAffiliation) e.getAffiliation();
        int memberId = (int) unionAffiliation.getMemberID();
        PayrollDatabase.getPayrollDatabase().removeUnionMember(memberId);
    }
}
