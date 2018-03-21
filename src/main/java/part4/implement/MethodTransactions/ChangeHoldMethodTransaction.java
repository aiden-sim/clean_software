package part4.implement.MethodTransactions;

import part4.implement.MethodTransactions.ChangeMethodTransaction;
import part4.implement.Methods.HoldMethod;
import part4.implement.PayrollDomain.PayrollMethod;

/**
 * 임금 지급 방식 변경 (담당자에게 직접 받기)
 */
public class ChangeHoldMethodTransaction extends ChangeMethodTransaction {
    public ChangeHoldMethodTransaction(int empId) {
        super(empId);
    }

    protected PayrollMethod getPaymentMethod() {
        return new HoldMethod();
    }
}
