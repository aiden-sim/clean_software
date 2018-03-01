package part3.salary;


import part3.implement.classification.CommissionedClassification;
import part3.implement.classification.HourlyClassification;
import part3.implement.classification.SalariedClassification;
import part3.implement.database.PayrollDatabase;
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
 * 1.增加雇员测试
 * Created by ZD on 2017/10/24.
 */
public class AddEmployTransactionTest {

    PayrollDatabase payrollDatabase = PayrollDatabase.getPayrollDatabase();

    @Test
    public void testaddSalariedEmployee(){
        int empId = 1;
        String name = "Bob";
        String address = "Bob.home";
        double monthlyPay = 1000.0;

        AddSalariedEmployee addSalariedEmployee = new AddSalariedEmployee(empId,name,address,monthlyPay);
        addSalariedEmployee.execute();

        Employee e = payrollDatabase.getEmployeeById(empId);

        SalariedClassification salariedClassification = (SalariedClassification) e.getPaymentClassification();

        MonthlySchedule monthlySchedule = (MonthlySchedule) e.getPaymentSchedule();
        System.out.println(monthlySchedule.toString());

        HoldMethod holdMethod = (HoldMethod) e.getPaymentMethod();
        assertNotNull(e);
    }

    @Test
    public void testaddHourlyEmployee(){
        long id = 2;
        String name = "Bobh";
        String address = "Bobh.home";
        double hourPay = 150;

        AddHourlyEmployee addHourlyEmployee = new AddHourlyEmployee(id,name,address,hourPay);
        addHourlyEmployee.execute();

        Employee e = payrollDatabase.getEmployeeById(id);
        assertEquals(e.getName(),name);

        HourlyClassification classification = (HourlyClassification) e.getPaymentClassification();
        assertEquals(hourPay,classification.getHourlyPay(),0.01);
    }


    @Test
    public void testAddCommissionedEmployee(){
        long id = 3;
        String name = "Bob3";
        String address = "Bob3.home";
        double monthPay = 200;
        double commissionRate = 5;

        AddCommissionedEmployee addCommissionedEmployee = new AddCommissionedEmployee(id,name,address,monthPay,commissionRate);
        addCommissionedEmployee.execute();

        Employee e = payrollDatabase.getEmployeeById(id);
        assertEquals(e.getName(),name);

        CommissionedClassification commissionedClassification = (CommissionedClassification) e.getPaymentClassification();

    }
}
