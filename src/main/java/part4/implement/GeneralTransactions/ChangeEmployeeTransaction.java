package part4.implement.GeneralTransactions;

import part4.implement.TransactionApplication.Transaction;
import part4.implement.PayrollDatabase.PayrollDatabase;
import part4.implement.PayrollDomain.Employee;

/**
 * 직원 변경 (템플릿 메소드)
 */
public abstract class ChangeEmployeeTransaction implements Transaction {
    private int isEmpId;

    public abstract void change(Employee e);

    public ChangeEmployeeTransaction(int empId) {
        this.isEmpId = empId;
    }

    public void execute() {
        Employee e = PayrollDatabase.getPayrollDatabase().getEmployee(isEmpId);
        if (e != null) {
            change(e);
        }
    }
}
