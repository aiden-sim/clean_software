package part3.implement.transaction;

import part3.implement.affiliation.Affiliation;
import part3.implement.affiliation.UnionAffiliation;
import part3.implement.database.PayrollDatabase;
import part3.implement.entity.Employee;

/**
 * 조합 변경 (조합원 추가)
 */
public class ChangeMemberTransaction extends ChangeAffiliationTransaction {
    private int itsMemberId;
    private double itsDues;

    public ChangeMemberTransaction(int empId, int memberId, double dues) {
        super(empId);
        this.itsMemberId = memberId;
        this.itsDues = dues;
    }

    @Override
    protected Affiliation getAffiliation() {
        return new UnionAffiliation(itsMemberId, itsDues);
    }

    protected void recordMemberShip(Employee e) {
        PayrollDatabase.getPayrollDatabase().addUnionMember(itsMemberId, e);
    }
}
