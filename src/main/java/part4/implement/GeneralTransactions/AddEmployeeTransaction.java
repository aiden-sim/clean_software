package part4.implement.GeneralTransactions;

import part4.implement.PayrollDomain.*;
import part4.implement.PayrollDatabase.PayrollDatabase;
import part4.implement.Methods.HoldMethod;
import part4.implement.TransactionApplication.Transaction;

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
        PayrollClassification pc = getClassification();
        PayrollSchedule ps = getSchdule();
        PayrollMethod pm = getHoldMethod();

        Employee e = new Employee(itsEmpid, itsName, itsAddress);
        e.setClassification(pc);
        e.setSchedule(ps);
        e.setMethod(pm);

        // 추가
        PayrollDatabase.getPayrollDatabase().addEmployee(itsEmpid, e);
    }

    protected PayrollMethod getHoldMethod() {
        return new HoldMethod();
    }

    protected abstract PayrollSchedule getSchdule();

    protected abstract PayrollClassification getClassification();

}
