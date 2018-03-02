package part3.salary;

import part3.implement.affiliation.Affiliation;
import part3.implement.affiliation.UnionAffiliation;
import part3.implement.classification.CommissionedClassification;
import part3.implement.classification.HourlyClassification;
import part3.implement.classification.PaymentClassification;
import part3.implement.classification.SalariedClassification;
import part3.implement.database.PayrollDatabase;
import part3.implement.entity.Employee;
import part3.implement.method.DirectMethod;
import part3.implement.method.HoldMethod;
import part3.implement.schedule.BiweeklySchedule;
import part3.implement.schedule.MonthlySchedule;
import part3.implement.schedule.PaymentSchedule;
import part3.implement.schedule.WeeklySchedule;
import part3.implement.transaction.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 직원변경
 */
public class ChangeEmployeeTransactionTest {

    PayrollDatabase payrollDatabase = PayrollDatabase.getPayrollDatabase();

    /**
     * 직원 이름 변경
     */
    @Test
    public void testChangeNameTransaction() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();

        // 이름 변경
        ChangeNameTransaction changeNameTransaction = new ChangeNameTransaction(empId, "Bob");
        changeNameTransaction.execute();

        Employee e = payrollDatabase.getEmployee(empId);
        assertNotNull(e);
        assertEquals("Bob", e.getName());
    }

    /**
     * 직원 주소 변경
     */
    @Test
    public void testChangeAddressTransaction() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();

        // 주소 변경
        ChangeEmployeeTransaction changeAddressTransaction = new ChangeAddressTransaction(empId, "Home2");
        changeAddressTransaction.execute();

        Employee e = payrollDatabase.getEmployee(empId);
        assertNotNull(e);
        assertEquals("Home2", e.getAddress());
    }

    /**
     * 직원 타입 변경 (알바)
     */
    @Test
    public void testChangeHourlyClassificationTransaction() {
        int empId = 3;

        AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Lance", "Home", 2500, 3.2);
        t.execute();

        // 직원 타입 변경
        ChangeHourlyTransaction cht = new ChangeHourlyTransaction(empId, 27.52);
        cht.execute();

        Employee e = payrollDatabase.getEmployee(empId);
        assertNotNull(e);

        PaymentClassification pc = e.getClassification();
        assertNotNull(pc);

        HourlyClassification hc = (HourlyClassification) pc;
        assertNotNull(hc);
        assertEquals(27.52, hc.getRate(), .001);

        PaymentSchedule ps = e.getSchedule();
        WeeklySchedule ws = (WeeklySchedule) ps;
        assertNotNull(ws);
    }

    /**
     * 직원 타입 변경 (일반)
     */
    @Test
    public void testChangeSalariedTransaction() {
        int empId = 3;

        AddHourlyEmployee addHourlyEmployee = new AddHourlyEmployee(empId, "Lance", "Home", 10);
        addHourlyEmployee.execute();

        // 직원 타입 변경
        ChangeSalariedTransaction cst = new ChangeSalariedTransaction(empId, 300);
        cst.execute();

        Employee e = payrollDatabase.getEmployee(empId);
        assertNotNull(e);

        PaymentClassification pc = e.getClassification();
        assertNotNull(pc);

        SalariedClassification sc = (SalariedClassification) pc;
        assertNotNull(sc);
        assertEquals(300, sc.getSalary(), .001);

        PaymentSchedule ps = e.getSchedule();
        MonthlySchedule ms = (MonthlySchedule) ps;
        assertNotNull(ms);

    }

    /**
     * 직원 타입 변경 (영업)
     */
    @Test
    public void testChangeCommissionedTransaction() {
        int empId = 3;

        AddSalariedEmployee addSalariedEmployee = new AddSalariedEmployee(empId, "Lance", "Home", 3300);
        addSalariedEmployee.execute();

        // 직원 타입 변경
        ChangeCommissionedTransaction cct = new ChangeCommissionedTransaction(empId, 3000, 5);
        cct.execute();

        Employee e = payrollDatabase.getEmployee(empId);
        assertNotNull(e);

        PaymentClassification pc = e.getClassification();
        assertNotNull(pc);

        CommissionedClassification cc = (CommissionedClassification) pc;
        assertNotNull(cc);

        PaymentSchedule ps = e.getSchedule();
        BiweeklySchedule bs = (BiweeklySchedule) ps;
        assertNotNull(bs);
    }

    /**
     * 임금 지급 방식 변경 (은행으로)
     */
    @Test
    public void testChangeDirectTransaction() {
        int empId = 1;

        AddSalariedEmployee addSalariedEmployee = new AddSalariedEmployee(empId, "Bob", "Home", 4000);
        addSalariedEmployee.execute();

        Employee e = payrollDatabase.getEmployee(empId);
        // 담당자에게 직접 받기 설정
        HoldMethod holdMethod = new HoldMethod();
        e.setItsPaymentMethod(holdMethod);

        // 은행으로 받는걸로 변경
        ChangeDirectTransaction changeDirectTransaction = new ChangeDirectTransaction(empId, "bank", 4000);
        changeDirectTransaction.execute();

        assertNotEquals(e.getMethod(), holdMethod);
    }

    /**
     * 임금 지급 방식 변경 (담당자에게)
     */
    @Test
    public void testChangeHoldMethod() {
        int empId = 1;

        AddHourlyEmployee addHourlyEmployee = new AddHourlyEmployee(empId, "Bob", "Home", 25);
        addHourlyEmployee.execute();

        Employee e = payrollDatabase.getEmployee(empId);
        // 은행으로 받기 설정
        DirectMethod directMethod = new DirectMethod("bank", 3000);
        e.setItsPaymentMethod(directMethod);

        // 담당자에게 받는걸로 변경
        ChangeHoldMethodTransaction changeHoldMethodTransaction = new ChangeHoldMethodTransaction(empId);
        changeHoldMethodTransaction.execute();

        assertNotEquals(e.getMethod(), directMethod);
    }

    /**
     * 임금 지급 방식 변경 (우편으로)
     */
    @Test
    public void testChangeMailMethod() {
        int empId = 1;

        AddSalariedEmployee addSalariedEmployee = new AddSalariedEmployee(empId, "Bob", "Home", 3000);
        addSalariedEmployee.execute();

        Employee e = payrollDatabase.getEmployee(empId);
        // 은행으로 받기 설정
        DirectMethod directMethod = new DirectMethod("bank", 3000);
        e.setItsPaymentMethod(directMethod);

        // 우편으로 받는걸로 변경
        ChangeMailMethodTransaction changeMailMethodTransaction = new ChangeMailMethodTransaction(empId, "Home");
        changeMailMethodTransaction.execute();

        assertNotEquals(e.getMethod(), directMethod);
    }

    /**
     * 조합 변경 (멤버)
     */
    @Test
    public void testChangeMemberTransaction() {
        int empId = 2;
        int memberId = 7734;

        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bill", "Home", 15.25);
        t.execute();

        ChangeMemberTransaction cmt = new ChangeMemberTransaction(empId, memberId, 99.42);
        cmt.execute();

        Employee e = payrollDatabase.getEmployee(empId);
        assertNotNull(e);

        Affiliation af = e.getItsAffiliation();
        UnionAffiliation uf = (UnionAffiliation) af;
        assertNotNull(uf);
        assertEquals(99.42, uf.getmDues(), .001);

        Employee member = payrollDatabase.getEmployeeByMemberId(memberId);
        assertNotNull(member);
        assertEquals(e, member);
    }

    /**
     * 조합 변경 (가입해제)
     */
    @Test
    public void testChangeUnaffiliatedTransaction() {
        int empId = 2;
        String name = "Bob";
        String address = "Bob.home";
        double hourlyPay = 25;

        int memberId = 4;
        double dues = 10;

        UnionAffiliation unionAffiliation = new UnionAffiliation(memberId, dues);

        AddHourlyEmployee addHourlyEmployee = new AddHourlyEmployee(empId, name, address, hourlyPay);
        addHourlyEmployee.execute();

        Employee e = payrollDatabase.getEmployee(empId);
        e.setItsAffiliation(unionAffiliation);

        payrollDatabase.addUnionMember(memberId, e);

        System.out.println(e.getItsAffiliation());

        ChangeUnaffiliatedTransaction changeUnaffiliatedTransation = new ChangeUnaffiliatedTransaction(empId);
        changeUnaffiliatedTransation.execute();
    }


}
