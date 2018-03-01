package part3.implement.transaction;

import part3.implement.database.PayrollDatabase;

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
