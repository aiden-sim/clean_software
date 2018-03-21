package part4.implement.MethodTransactions;

import part4.implement.MethodTransactions.ChangeMethodTransaction;
import part4.implement.Methods.MailMethod;
import part4.implement.PayrollDomain.PayrollMethod;

/**
 * 임금 지급 방식 변경 (우편으로 받기)
 */
public class ChangeMailMethodTransaction extends ChangeMethodTransaction {
    private String mailAdress;

    public ChangeMailMethodTransaction(int empId, String mailAdress) {
        super(empId);
        this.mailAdress = mailAdress;
    }

    protected PayrollMethod getPaymentMethod() {
        return new MailMethod(mailAdress);
    }
}
