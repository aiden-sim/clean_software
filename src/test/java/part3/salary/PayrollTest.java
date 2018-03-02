package part3.salary;

import part3.implement.payday.PayCheck;
import part3.implement.transaction.*;
import part3.implement.util.DateUtil;
import org.junit.Test;


import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * 임금 지급
 */
public class PayrollTest {

    /**
     * 일반 직원 임금 지급 (그 달의 마지막 평일)
     */
    @Test
    public void testPaySalariedEmployee() {
        int empId = 1;

        // 일반 직원 추가
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
        t.execute();

        Date payDate = DateUtil.getDateFormat("2001-11-30");
        PayDayTransaction pt = new PayDayTransaction(payDate);
        pt.execute();

        PayCheck pc = pt.getPayCheck(empId);
        assertNotNull(pc);
        assertEquals(payDate, pc.getPayDate());
        assertEquals(1000.00, pc.getGrossPay(), .001);
        //assertEquals("Hold", pc.getFields());
        assertEquals(0.0, pc.getDetuctions(), .001);
        assertEquals(1000.00, pc.getNetPay(), .001);
    }

    /**
     * 일반 직원 임금 지급 (잘못된 날짜)
     */
    @Test
    public void testPaySalariedEmployeeOnWrongDate() {
        int empId = 1;

        // 일반 직원 추가
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
        t.execute();

        Date payDate = DateUtil.getDateFormat("2001-11-29");
        PayDayTransaction pt = new PayDayTransaction(payDate);
        pt.execute();

        // 급여 체크
        PayCheck payCheck = pt.getPayCheck(empId);
        assertEquals(null, payCheck);
    }

    /**
     * 알바 직원 임금 지급 (주의 금요일)
     */
    @Test
    public void testPayHourlyEmployee() {
        int empId = 2;

        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();

        Date payDate = DateUtil.getDateFormat("2001-11-09"); // 금요일

        PayDayTransaction pt = new PayDayTransaction(payDate);
        pt.execute();

        validateHourlyPaycheck(pt, empId, payDate, 0.0);
    }

    private void validateHourlyPaycheck(PayDayTransaction pt, int empId, Date payDate, double pay) {
        PayCheck pc = pt.getPayCheck(empId);
        assertNotNull(pc);
        assertEquals(pc.getPayDate(), payDate);
        //assertEquals("Hold", pc.getFields());
        assertEquals(0.0, pc.getDetuctions(), .001);
        assertEquals(pay, pc.getNetPay(), .001);
    }

    /**
     * 알바 직원 추가 임금 지급 (8시간)
     */
    @Test
    public void testPaySingleHourlyEmployeeOneTimeCard() throws Exception {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();

        Date payDate = DateUtil.getDateFormat("2001-11-09"); // 금요일

        TimeCardTransaction tc = new TimeCardTransaction(payDate, 2.0, empId);
        tc.execute();
        PayDayTransaction pt = new PayDayTransaction(payDate);
        pt.execute();

        validateHourlyPaycheck(pt, empId, payDate, 0.0);
    }

    /**
     * 알바 직원 임금 지급 (잘못된 날짜)
     */
    @Test
    public void testPaySingleHourlyEmployeeOnWrongDate() throws Exception {
        int empId = 1;

        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();

        Date payDate = DateUtil.getDateFormat("2001-11-08");
        TimeCardTransaction tc = new TimeCardTransaction(payDate, 9.0, empId);
        tc.execute();

        PayDayTransaction pt = new PayDayTransaction(payDate);
        pt.execute();

        PayCheck pc = pt.getPayCheck(empId);
        assertEquals(null, pc);
    }

    /**
     * 타임카드가 하나 이상인 직원의 임금을 계산할 수 있음을 확인
     */
    @Test
    public void testPaySingleHourlyEmployeeTwoTimeCards() throws Exception {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();

        Date payDate = DateUtil.getDateFormat("2001-11-09"); // 금요일
        TimeCardTransaction tc = new TimeCardTransaction(payDate, 2.0, empId);
        tc.execute();
        TimeCardTransaction tc2 = new TimeCardTransaction(DateUtil.getDateFormat("2001-11-08"), 2.0, empId); // 목요일
        tc2.execute();

        PayDayTransaction pt = new PayDayTransaction(payDate);
        pt.execute();
        validateHourlyPaycheck(pt, empId, payDate, 30.5);
    }

    /**
     * 직원이 가진 현재 지급 주기의 타임카드에 대해서만 임금을 지급
     */
    @Test
    public void testPaySingelHourlyEmployeeWithTimeCardsSpanningTwoPayPeriods() throws Exception {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();

        Date payDate = DateUtil.getDateFormat("2001-11-09"); // 금요일
        Date dateInPreviousPayPeriod = DateUtil.getDateFormat("2001-11-02");

        TimeCardTransaction tc = new TimeCardTransaction(payDate, 2.0, empId);
        tc.execute();

        TimeCardTransaction tc2 = new TimeCardTransaction(dateInPreviousPayPeriod, 2.0, empId);
        tc2.execute();

        PayDayTransaction pt = new PayDayTransaction(payDate);
        pt.execute();
        validateHourlyPaycheck(pt, empId, payDate, 0.0);
    }

    /**
     * 월급 받는 직원 추가후, 조합원으로 변경한다음,
     * 임금을 지급한 후 조합비가 임금에서 빠져나갔는지 테스트
     */
    @Test
    public void testSalariedUnionMemeberDues() {
        int empId = 1;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bob", "Home", 1000.00);
        t.execute();

        int memberId = 7734;
        ChangeMemberTransaction cmt = new ChangeMemberTransaction(empId, memberId, 9.42);
        cmt.execute();

        Date payDate = DateUtil.getDateFormat("2001-11-30"); // 금요일
        PayDayTransaction pt = new PayDayTransaction(payDate);
        pt.execute();
    }


    @Test
    public void testHourlyUnionMemberServiceCharge() throws Exception {
        int empId = 1;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.24);
        t.execute();

        // 조합 가입
        int memberId = 7734;
        ChangeMemberTransaction cmt = new ChangeMemberTransaction(empId, memberId, 9.42);
        cmt.execute();

        Date payDate = DateUtil.getDateFormat("2001-11-09"); // 금요일
        // 공제액 부과
        ServiceChargeTransaction sct = new ServiceChargeTransaction(memberId, payDate, 19.42);
        sct.execute();

        // 일한 시간
        TimeCardTransaction tct = new TimeCardTransaction(payDate, 8.0, empId);
        tct.execute();

        // 월급 지급
        PayDayTransaction pt = new PayDayTransaction(payDate);
        pt.execute();

        PayCheck pc = pt.getPayCheck(empId);
        assertNotNull(pc);
        assertEquals(pc.getPayPeriodEndDate(), payDate);
        //assertEquals(8 * 15.24, pc.getGrossPay(), .001);
        //assertEquals("Hold", pc.getFields());
        //assertEquals(9.42 + 19.42, pc.getDetuctions(), .001);
        //assertEquals((8 * 15.24) - (9.42 + 19.42), pc.getNetPay(), .001);

    }
}
