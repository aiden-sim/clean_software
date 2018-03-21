package part4.implement.MethodTransactions;

import part4.implement.MethodTransactions.ChangeMethodTransaction;
import part4.implement.Methods.DirectMethod;
import part4.implement.PayrollDomain.PayrollMethod;

/**
 * 임금 지급 방식 변경 (은행으로)
 */
public class ChangeDirectTransaction extends ChangeMethodTransaction {

    private String bank;
    private double account;

    public ChangeDirectTransaction(int empId, String bank, double account) {
        super(empId);
        this.bank = bank;
        this.account = account;
    }

    protected PayrollMethod getPaymentMethod() {
        return new DirectMethod(bank, account);
    }
}
