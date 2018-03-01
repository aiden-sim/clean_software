package part3.implement.transaction;

import part3.implement.method.HoldMethod;
import part3.implement.method.PaymentMethod;

/**
 * Created by ZD on 2017/10/26.
 */
public class ChangeHoldMethodTransaction extends ChangeMethodTransaction{

    public ChangeHoldMethodTransaction(){}

    public ChangeHoldMethodTransaction(int empId){
        super(empId);
    }


    protected PaymentMethod getPaymentMethod() {
        return new HoldMethod();
    }
}
