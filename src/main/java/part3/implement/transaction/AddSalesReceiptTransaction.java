package part3.implement.transaction;

import part3.implement.classification.CommissionedClassification;
import part3.implement.database.PayrollDatabase;
import part3.implement.entity.Employee;
import part3.implement.entity.SalesReceipt;

import java.util.Date;


/**
 * Created by ZD on 2017/10/24.
 */
public class AddSalesReceiptTransaction implements Transaction {

    private Date date;
    private int amount;
    private long id;



    public AddSalesReceiptTransaction(Date date, int amount, long id) {
        this.date = date;
        this.amount = amount;
        this.id = id;
    }

    public AddSalesReceiptTransaction(){}

    public void execute() {
        SalesReceipt salesReceipt = new SalesReceipt(date,amount);
        Employee e = PayrollDatabase.getPayrollDatabase().getEmployeeById(id);
        CommissionedClassification commissionedClassification = (CommissionedClassification) e.getPaymentClassification();
        commissionedClassification.addSalesReceipt(salesReceipt);
    }
}
