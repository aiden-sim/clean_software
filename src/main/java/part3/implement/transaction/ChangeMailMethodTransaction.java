package part3.implement.transaction;

import part3.implement.method.MailMethod;
import part3.implement.method.PaymentMethod;

/**
 * 임금 지급 방식 변경 (우편으로 받기)
 */
public class ChangeMailMethodTransaction extends ChangeMethodTransaction {
    private String mailAdress;

    public ChangeMailMethodTransaction(int empId, String mailAdress) {
        super(empId);
        this.mailAdress = mailAdress;
    }

    protected PaymentMethod getPaymentMethod() {
        return new MailMethod(mailAdress);
    }
}
