package part3.implement.transaction;

import part3.implement.classification.PaymentClassification;
import part3.implement.database.PayrollDatabase;
import part3.implement.entity.Employee;
import part3.implement.method.HoldMethod;
import part3.implement.method.PaymentMethod;
import part3.implement.schedule.PaymentSchedule;

/**
 * 직원 추가 (템플릿 메소드)
 */
public abstract class AddEmployeeTransaction implements Transaction {

    private int itsEmpid;
    private String itsName;
    private String itsAddress;

    public AddEmployeeTransaction(int empId, String name, String address) {
        this.itsEmpid = empId;
        this.itsName = name;
        this.itsAddress = address;
    }

    // 템플릿 메소드
    public void execute() {
        PaymentClassification pc = getClassification();
        PaymentSchedule ps = getSchdule();
        PaymentMethod pm = getHoldMethod();

        Employee e = new Employee(itsEmpid, itsName, itsAddress);
        e.setClassification(pc);
        e.setSchedule(ps);
        e.setMethod(pm);

        // 추가
        PayrollDatabase.getPayrollDatabase().addEmployee(itsEmpid, e);
    }

    protected PaymentMethod getHoldMethod() {
        return new HoldMethod();
    }

    protected abstract PaymentSchedule getSchdule();

    protected abstract PaymentClassification getClassification();

}
