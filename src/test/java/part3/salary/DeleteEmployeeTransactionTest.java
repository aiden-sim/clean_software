package part3.salary;

import part3.implement.database.PayrollDatabase;
import part3.implement.entity.Employee;
import part3.implement.transaction.AddCommissionedEmployee;
import part3.implement.transaction.AddSalariedEmployee;
import part3.implement.transaction.DeleteEmployeeTransaction;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * 직원 삭제 테스트코드
 */
public class DeleteEmployeeTransactionTest {
    PayrollDatabase payrollDatabase = PayrollDatabase.getPayrollDatabase();

    @Test
    public void testDeleteEmployee(){
        int empId = 3;
        AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Lance", "Home", 2500, 3.2);
        t.execute();
        {
            Employee e = payrollDatabase.getEmployee(empId);
            assertNotNull(e);
        }

        DeleteEmployeeTransaction dt = new DeleteEmployeeTransaction(empId);
        dt.execute();
        {
            Employee e = payrollDatabase.getEmployee(empId);
            assertNull(e);
        }
    }
}
