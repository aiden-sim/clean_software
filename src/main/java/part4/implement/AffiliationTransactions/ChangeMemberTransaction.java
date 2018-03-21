package part4.implement.AffiliationTransactions;

import part4.implement.PayrollDomain.Affiliation;
import part4.implement.Affiliations.UnionAffiliation;
import part4.implement.PayrollDatabase.PayrollDatabase;
import part4.implement.PayrollDomain.Employee;

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
