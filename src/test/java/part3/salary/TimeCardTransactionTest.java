package part3.salary;

import part3.implement.classification.HourlyClassification;
import part3.implement.classification.PaymentClassification;
import part3.implement.database.PayrollDatabase;
import part3.implement.entity.Employee;
import part3.implement.entity.TimeCard;
import part3.implement.transaction.AddHourlyEmployee;
import part3.implement.transaction.TimeCardTransaction;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * 알바 직원 추가 테스트코드
 * 타임카드도 같이 추가
 */
public class TimeCardTransactionTest {
    PayrollDatabase payrollDatabase = PayrollDatabase.getPayrollDatabase();

    @Test
    public void addTimeCardTest() throws Exception {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();

        Date date = new Date(2001, 10, 31);
        TimeCardTransaction tct = new TimeCardTransaction(date, 8.0, empId);
        tct.execute();

        Employee e = payrollDatabase.getEmployee(empId);
        assertNotNull(e);

        PaymentClassification pc = e.getClassification();
        HourlyClassification hc = (HourlyClassification) pc;
        assertNotNull(hc);

        TimeCard tc = hc.getTimeCard(date);
        assertNotNull(tc);
        assertEquals(8.0, tc.getHours(), 0.001);
    }
}
