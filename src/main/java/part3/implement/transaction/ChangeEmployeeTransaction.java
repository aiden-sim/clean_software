package part3.implement.transaction;

import part3.implement.database.PayrollDatabase;
import part3.implement.entity.Employee;

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
