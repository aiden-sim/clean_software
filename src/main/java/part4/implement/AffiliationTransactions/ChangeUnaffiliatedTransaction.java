package part4.implement.AffiliationTransactions;

import part4.implement.PayrollDomain.Affiliation;
import part4.implement.Affiliations.NoAffiliation;
import part4.implement.Affiliations.UnionAffiliation;
import part4.implement.PayrollDatabase.PayrollDatabase;
import part4.implement.PayrollDomain.Employee;

/**
 * 조합 변경 (조합원 탈퇴)
 */
public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {

    public ChangeUnaffiliatedTransaction(int empId) {
        super(empId);
    }

    protected Affiliation getAffiliation() {
        return new NoAffiliation();
    }

    protected void recordMemberShip(Employee e) {
        UnionAffiliation unionAffiliation = (UnionAffiliation) e.getItsAffiliation();
        int memberId = unionAffiliation.getMemberID();
        PayrollDatabase.getPayrollDatabase().deleteUnionMember(memberId);
    }
}
