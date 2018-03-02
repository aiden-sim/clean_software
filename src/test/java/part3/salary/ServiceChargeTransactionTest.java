package part3.salary;

import org.junit.Test;
import part3.implement.affiliation.UnionAffiliation;
import part3.implement.database.PayrollDatabase;
import part3.implement.entity.Employee;
import part3.implement.entity.ServiceCharge;
import part3.implement.transaction.AddHourlyEmployee;
import part3.implement.transaction.ServiceChargeTransaction;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * 조합 공제 테스트코드
 */
public class ServiceChargeTransactionTest {
    PayrollDatabase payrollDatabase = PayrollDatabase.getPayrollDatabase();

    @Test
    public void testAddServiceChargeTransaction() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();
        Employee e = payrollDatabase.getEmployee(empId);
        assertNotNull(e);

        UnionAffiliation af = new UnionAffiliation(empId, 12.5);
        e.setItsAffiliation(af);

        // 조합 추가
        int memberId = 86;  // Maxwell Smart
        payrollDatabase.addUnionMember(memberId, e);

        // 공제액 부과
        ServiceChargeTransaction sct = new ServiceChargeTransaction(memberId, new Date(2001, 11, 01), 12.95);
        sct.execute();

        ServiceCharge sc = af.getServiceCharge(new Date(2001, 11, 01));
        assertNotNull(sc);
        assertEquals(12.95, sc.getAmount(), .001);
    }
}
