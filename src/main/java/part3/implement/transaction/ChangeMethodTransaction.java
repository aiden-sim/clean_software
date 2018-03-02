package part3.implement.transaction;

import part3.implement.entity.Employee;
import part3.implement.method.PaymentMethod;

/**
 * 임금 지급 방식 변경
 */
public abstract class ChangeMethodTransaction extends ChangeEmployeeTransaction {

    protected abstract PaymentMethod getPaymentMethod();

    public ChangeMethodTransaction(int empId) {
        super(empId);
    }

    @Override
    public void change(Employee e) {
        e.setItsPaymentMethod(getPaymentMethod());
    }

}
