package part3.salary;


import part3.implement.classification.CommissionedClassification;
import part3.implement.classification.HourlyClassification;
import part3.implement.classification.PaymentClassification;
import part3.implement.classification.SalariedClassification;
import part3.implement.database.PayrollDatabase;
import part3.implement.method.PaymentMethod;
import part3.implement.schedule.PaymentSchedule;
import part3.implement.transaction.AddCommissionedEmployee;
import part3.implement.transaction.AddHourlyEmployee;
import part3.implement.entity.Employee;
import part3.implement.method.HoldMethod;
import part3.implement.schedule.MonthlySchedule;
import part3.implement.transaction.AddSalariedEmployee;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * 직원 추가 테스트코드
 */
public class AddEmployTransactionTest {
    PayrollDatabase payrollDatabase = PayrollDatabase.getPayrollDatabase();

    /**
     * 일반직원
     */
    @Test
    public void testaddSalariedEmployee() {
        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
        t.execute();

        Employee e = payrollDatabase.getEmployee(empId);
        assertEquals("Bob", e.getName());

        PaymentClassification pc = e.getClassification();
        SalariedClassification sc = (SalariedClassification) pc;
        assertNotNull(sc);
        assertEquals(1000.00, sc.getSalary(), .001);

        PaymentSchedule ps = e.getSchedule();
        MonthlySchedule ms = (MonthlySchedule) ps;
        assertNotNull(ms);

        PaymentMethod pm = e.getMethod();
        HoldMethod hm = (HoldMethod) pm;
        assertNotNull(hm);
    }

    /**
     * 알바
     */
    @Test
    public void testaddHourlyEmployee() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bob2", "Home", 150);
        t.execute();

        Employee e = payrollDatabase.getEmployee(empId);
        assertEquals("Bob2", e.getName());

        PaymentClassification pc = e.getClassification();
        HourlyClassification hc = (HourlyClassification)pc;
        assertEquals(150, hc.getRate(), 0.01);
    }


    /**
     * 일반직원 + 수수료
     */
    @Test
    public void testAddCommissionedEmployee() {
        int empId = 3;
        AddCommissionedEmployee t = new AddCommissionedEmployee(3, "Bob3", "Home", 1000.00, 10);
        t.execute();

        Employee e = payrollDatabase.getEmployee(empId);
        assertEquals("Bob3", e.getName());

        PaymentClassification pc = e.getClassification();
        CommissionedClassification cc = (CommissionedClassification)pc;
    }
}
