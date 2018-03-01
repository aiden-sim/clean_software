package part3.chapter19;

import org.junit.Assert;
import org.junit.Test;
import part3.chapter19.classification.CommissionedClassification;
import part3.chapter19.classification.HourlyClassification;
import part3.chapter19.classification.PaymentClassification;
import part3.chapter19.classification.SalariedClassification;
import part3.chapter19.payschedule.BiWeeklySchedule;
import part3.chapter19.payschedule.MonthlySchedule;
import part3.chapter19.payschedule.PaymentSchedule;
import part3.chapter19.payschedule.WeeklySchedule;

import java.time.LocalDate;

public class PayrollTest {
    @Test
    public void testAddSalariedEmployee() {
        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
        t.execute();

        Employee e = GpayrollDatabase.getEmployee(empId);
        Assert.assertEquals("Bob", e.getName());
        Assert.assertEquals("Home", e.getAddress());

        PaymentClassification pc = e.getPaymentClassfication();
        Assert.assertTrue(pc instanceof SalariedClassification);
        Assert.assertEquals(1000.00, pc.getSalary(), 0.0001);

        PaymentSchedule ps = e.getPaymentSchedule();
        Assert.assertTrue(ps instanceof MonthlySchedule);

        PaymentMethod pm = e.getPaymentMethod();
        Assert.assertTrue(pm instanceof HoldMethod);

    }

    @Test
    public void testAddHourlyEmployee() {
        int empId = 1;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bob1", "Home1", 50);
        t.execute();

        Employee e = GpayrollDatabase.getEmployee(empId);
        Assert.assertEquals("Bob1", e.getName());
        Assert.assertEquals("Home1", e.getAddress());

        PaymentClassification pc = e.getPaymentClassfication();
        Assert.assertTrue(pc instanceof HourlyClassification);

        PaymentSchedule ps = e.getPaymentSchedule();
        Assert.assertTrue(ps instanceof WeeklySchedule);

        PaymentMethod pm = e.getPaymentMethod();
        Assert.assertTrue(pm instanceof HoldMethod);
    }

    @Test
    public void testAddCommissionedEmployee() {
        int empId = 1;
        AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Bob2", "Home2", 2000,  0.2);
        t.execute();

        Employee e = GpayrollDatabase.getEmployee(empId);
        Assert.assertEquals("Bob2", e.getName());
        Assert.assertEquals("Home2", e.getAddress());

        PaymentClassification pc = e.getPaymentClassfication();
        Assert.assertTrue(pc instanceof CommissionedClassification);

        PaymentSchedule ps = e.getPaymentSchedule();
        Assert.assertTrue(ps instanceof BiWeeklySchedule);

        PaymentMethod pm = e.getPaymentMethod();
        Assert.assertTrue(pm instanceof HoldMethod);
    }

    @Test
    public void testDeleteEmployee() {
        int empId = 3;
        AddCommissionedEmployee t = new AddCommissionedEmployee(empId,
            "Lance", "Home", 2500, 3.2);
        t.execute();
        {
            Employee e = GpayrollDatabase.getEmployee(empId);
            Assert.assertNotNull(e);
        }
        DeleteEmployeeTransaction dt = new DeleteEmployeeTransaction(empId);
        dt.execute();
        {
            Employee e = GpayrollDatabase.getEmployee(empId);
            Assert.assertNull(e);
        }
    }

    @Test
    public void testTimeCardTransaction() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();

        LocalDate date = LocalDate.of(2001, 10, 31);
        TimeCardTransaction tct = new TimeCardTransaction(date,8.0, empId);
        tct.execute();

        Employee e = GpayrollDatabase.getEmployee(empId);
        Assert.assertNotNull(e);

        HourlyClassification hc = (HourlyClassification) e.getPaymentClassfication();
        Assert.assertNotNull(hc);
        TimeCard tc = hc.getTimeCard(date);
        Assert.assertNotNull(tc);
        Assert.assertEquals(8.0, tc.getHours(), 0.0001);

    }

    @Test
    public void testSalesReceiptTransaction() {
        int empId = 2;
        AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Bill", "Home", 2000, 0.2);
        t.execute();

        LocalDate date = LocalDate.of(2011, 5, 7);
        SalesReceiptTransaction srt = new SalesReceiptTransaction(date, 8000, empId);
        srt.execute();

        Employee e = GpayrollDatabase.getEmployee(empId);
        Assert.assertNotNull(e);

        CommissionedClassification cc = (CommissionedClassification) e.getPaymentClassfication();
        SalesReceipt sr = cc.getSalesReceipt(date);
        Assert.assertNotNull(sr);
        Assert.assertEquals(8000, sr.getAmount(), 0.0001);
    }

    @Test
    public void testAddServiceCharge() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();

        Employee e = GpayrollDatabase.getEmployee(empId);
        Assert.assertNotNull(e);

        int memberId = 86;
        UnionAffiliation af = new UnionAffiliation(memberId, 12.5);
        e.setAffilication(af);

        GpayrollDatabase.AddUnionMember(memberId, e);
        LocalDate date = LocalDate.of(2001, 11, 1);
        ServiceChargeTransaction sct = new ServiceChargeTransaction(memberId, date, 12.95);
        sct.execute();

        ServiceCharge sc = af.getServiceCharge(date);
        Assert.assertNotNull(sc);
        Assert.assertEquals(12.95, sc.getAmount(), 0.0001);

    }
}
