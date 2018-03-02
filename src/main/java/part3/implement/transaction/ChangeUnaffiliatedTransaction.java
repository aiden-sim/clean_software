package part3.implement.transaction;

import part3.implement.affiliation.Affiliation;
import part3.implement.affiliation.NoAffiliation;
import part3.implement.affiliation.UnionAffiliation;
import part3.implement.database.PayrollDatabase;
import part3.implement.entity.Employee;

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
