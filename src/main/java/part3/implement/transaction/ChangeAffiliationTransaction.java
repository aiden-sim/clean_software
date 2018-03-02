package part3.implement.transaction;

import part3.implement.affiliation.Affiliation;
import part3.implement.entity.Employee;

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
