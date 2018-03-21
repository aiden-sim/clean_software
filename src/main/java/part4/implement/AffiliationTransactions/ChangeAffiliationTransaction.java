package part4.implement.AffiliationTransactions;

import part4.implement.PayrollDomain.Affiliation;
import part4.implement.PayrollDomain.Employee;
import part4.implement.GeneralTransactions.ChangeEmployeeTransaction;

/**
 * 조합 변경 (템플릿 메소드 패턴)
 */
public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {
    protected abstract Affiliation getAffiliation();

    protected abstract void recordMemberShip(Employee e);

    public ChangeAffiliationTransaction(int empId) {
        super(empId);
    }

    public void change(Employee e) {
        recordMemberShip(e);
        e.setItsAffiliation(getAffiliation());
    }
}
