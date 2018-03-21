package part4.implement.ClassificationTransaction;

import part4.implement.TransactionApplication.Transaction;
import part4.implement.Classifications.CommissionedClassification;
import part4.implement.PayrollDomain.PayrollClassification;
import part4.implement.PayrollDatabase.PayrollDatabase;
import part4.implement.PayrollDomain.Employee;
import part4.implement.Classifications.SalesReceipt;

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
            PayrollClassification pc = e.getClassification();
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
