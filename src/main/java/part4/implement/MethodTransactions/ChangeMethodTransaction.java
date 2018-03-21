package part4.implement.MethodTransactions;

import part4.implement.PayrollDomain.Employee;
import part4.implement.PayrollDomain.PayrollMethod;
import part4.implement.GeneralTransactions.ChangeEmployeeTransaction;

/**
 * 임금 지급 방식 변경
 */
public abstract class ChangeMethodTransaction extends ChangeEmployeeTransaction {

    protected abstract PayrollMethod getPaymentMethod();

    public ChangeMethodTransaction(int empId) {
        super(empId);
    }

    @Override
    public void change(Employee e) {
        e.setItsPayrollMethod(getPaymentMethod());
    }

}
