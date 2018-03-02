package part3.implement.transaction;

import part3.implement.classification.PaymentClassification;

import part3.implement.entity.Employee;
import part3.implement.schedule.PaymentSchedule;

/**
 * 직원 임금 종류 변경 ( 템플릿 메소드 )
 */
public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {
    protected abstract PaymentClassification getClassification();

    protected abstract PaymentSchedule getSchedule();

    public ChangeClassificationTransaction(int empId) {
        super(empId);
    }

    // 템플릿 메소드
    public void change(Employee e) {
        e.setClassification(getClassification());
        e.setSchedule(getSchedule());
    }
}
