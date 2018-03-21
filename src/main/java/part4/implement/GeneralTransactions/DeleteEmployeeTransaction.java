package part4.implement.GeneralTransactions;

import part4.implement.TransactionApplication.Transaction;
import part4.implement.PayrollDatabase.PayrollDatabase;

/**
 * 직원 삭제
 */
public class DeleteEmployeeTransaction implements Transaction {
    private int itsEmpId;

    public DeleteEmployeeTransaction(int empId) {
        this.itsEmpId = empId;
    }

    public void execute() {
        PayrollDatabase.getPayrollDatabase().deleteEmployeeById(itsEmpId);
    }
}
