package part3.salary;

import part3.implement.classification.CommissionedClassification;
import part3.implement.database.PayrollDatabase;
import part3.implement.entity.Employee;
import part3.implement.entity.SalesReceipt;
import part3.implement.transaction.AddCommissionedEmployee;
import part3.implement.transaction.SalesReceiptTransaction;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * 영수증 테스트
 */
public class SalesReceiptTransactionTest {

    PayrollDatabase payrollDatabase = PayrollDatabase.getPayrollDatabase();

    @Test
    public void testSalesReceiptTransaction() throws Exception {
        int id = 2;

        AddCommissionedEmployee addCommissionedEmployee = new AddCommissionedEmployee(id, "Bob", "Home", 1000, 5);
        addCommissionedEmployee.execute();

        Date date = new Date(2017, 10, 24);

        SalesReceiptTransaction salesReceiptTransaction = new SalesReceiptTransaction(date, 3, id);
        salesReceiptTransaction.execute();

        Employee e = payrollDatabase.getEmployee(id);

        CommissionedClassification commissionedClassification = (CommissionedClassification) e.getClassification();

        SalesReceipt salesReceipt = commissionedClassification.getSalesReceipt(date);

        assertEquals(salesReceipt.getItsAmount(), 3);
    }

}
