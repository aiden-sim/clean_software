package part3.implement.transaction;

import part3.implement.classification.PaymentClassification;

import part3.implement.entity.Employee;
import part3.implement.schedule.PaymentSchedule;

/**
 * 更改类别
 * Created by ZD on 2017/10/25.
 */
public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {

    public ChangeClassificationTransaction(){}

    public ChangeClassificationTransaction(int empId){
        super(empId);
    }

    public void change(Employee e) {
        e.setClassification(getClassification());
        e.setSchedule(getSchedule());

    }

    protected abstract PaymentSchedule getSchedule();

    protected abstract PaymentClassification getClassification();


}
