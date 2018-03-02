package part3.implement.transaction;

import part3.implement.method.HoldMethod;
import part3.implement.method.PaymentMethod;

/**
 * 임금 지급 방식 변경 (담당자에게 직접 받기)
 */
public class ChangeHoldMethodTransaction extends ChangeMethodTransaction {
    public ChangeHoldMethodTransaction(int empId) {
        super(empId);
    }

    protected PaymentMethod getPaymentMethod() {
        return new HoldMethod();
    }
}
