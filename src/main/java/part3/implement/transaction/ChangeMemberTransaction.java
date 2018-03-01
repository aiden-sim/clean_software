package part3.implement.transaction;

import part3.implement.affiliation.Affiliation;
import part3.implement.affiliation.NoAffiliation;
import part3.implement.affiliation.UnionAffiliation;
import part3.implement.database.PayrollDatabase;
import part3.implement.entity.Employee;

/**
 * Created by ZD on 2017/10/25.
 */
public class ChangeMemberTransaction extends ChangeAffiliationTransaction {

    private int memberId;
    private double dues;//会费

    public ChangeMemberTransaction(long empId,int memberId,double dues){
        super((int) empId);
        this.memberId = memberId;
        this.dues = dues;
    }

    public ChangeMemberTransaction(){}


    @Override
    protected UnionAffiliation getAffiliation() {
        return new UnionAffiliation(memberId,dues);
    }

    protected void recordMemberShip(Employee e) {
        PayrollDatabase.getPayrollDatabase().addUnionMember(memberId,e);
    }
}
