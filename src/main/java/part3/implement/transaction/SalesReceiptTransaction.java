package part3.implement.transaction;

import part3.implement.classification.CommissionedClassification;
import part3.implement.classification.PaymentClassification;
import part3.implement.database.PayrollDatabase;
import part3.implement.entity.Employee;
import part3.implement.entity.SalesReceipt;

import java.util.Date;


/**
 * 수수료(영수증 기록) 트랜잭션
 */
public class SalesReceiptTransaction implements Transaction {
    private Date itsDate;
    private int itsAmount;
    private int itsEmpId;

    public SalesReceiptTransaction(Date date, int amount, int empId) {
        this.itsDate = date;
        this.itsAmount = amount;
        this.itsEmpId = empId;
    }

    public void execute() throws Exception {
        Employee e = PayrollDatabase.getPayrollDatabase().getEmployee(itsEmpId);
        if (e != null) {
            PaymentClassification pc = e.getClassification();
            if (pc instanceof CommissionedClassification) {
                CommissionedClassification cc = (CommissionedClassification) pc;
                cc.addSalesReceipt(new SalesReceipt(itsDate, itsAmount));
            } else {
                throw new Exception("Tried to add receipt to non-commissioned employee");
            }
        } else {
            throw new Exception("No such employee.");
        }
    }
}
