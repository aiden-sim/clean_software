package part4.implement.ClassificationTransaction;

import part4.implement.PayrollDomain.PayrollClassification;
import part4.implement.PayrollDomain.Employee;
import part4.implement.PayrollDomain.PayrollSchedule;
import part4.implement.GeneralTransactions.ChangeEmployeeTransaction;

/**
 * 직원 임금 종류 변경 ( 템플릿 메소드 )
 */
public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {
    protected abstract PayrollClassification getClassification();

    protected abstract PayrollSchedule getSchedule();

    public ChangeClassificationTransaction(int empId) {
        super(empId);
    }

    // 템플릿 메소드
    public void change(Employee e) {
        e.setClassification(getClassification());
        e.setSchedule(getSchedule());
    }
}
