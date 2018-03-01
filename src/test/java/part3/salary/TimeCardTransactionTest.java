package part3.salary;

import part3.implement.classification.HourlyClassification;
import part3.implement.database.PayrollDatabase;
import part3.implement.entity.Employee;
import part3.implement.entity.TimeCard;
import part3.implement.transaction.AddHourlyEmployee;
import part3.implement.transaction.AddTimecardTransaction;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * 时间卡测试
 * Created by ZD on 2017/10/24.
 */
public class TimeCardTransactionTest {

    PayrollDatabase payrollDatabase = PayrollDatabase.getPayrollDatabase();

    @Test
    public void addTimeCardTest(){
        int empId = 5;
        String name = "Bob5";
        String address = "Bob5.home";
        double hourlyPay = 20;

        AddHourlyEmployee addHourlyEmployee = new AddHourlyEmployee(empId,name,address,hourlyPay);
        addHourlyEmployee.execute();

        Date date = new Date(2017,10,24);

        AddTimecardTransaction timecardTransaction = new AddTimecardTransaction(date,8.0,empId);
        timecardTransaction.execute();

        Employee e = payrollDatabase.getEmployeeById(empId);

        HourlyClassification paymentClassification = (HourlyClassification) e.getPaymentClassification();

        TimeCard timeCard = paymentClassification.getTimeCard(date);
      System.out.println(((HourlyClassification) e.getPaymentClassification()).getTimeCard(date).getHours());


    }
}
