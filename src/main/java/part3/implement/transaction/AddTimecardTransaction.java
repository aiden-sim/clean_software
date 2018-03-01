package part3.implement.transaction;

import part3.implement.classification.HourlyClassification;
import part3.implement.classification.PaymentClassification;
import part3.implement.database.PayrollDatabase;
import part3.implement.entity.Employee;
import part3.implement.entity.TimeCard;

import java.util.Date;

/**
 * Created by ZD on 2017/10/24.
 */
public class AddTimecardTransaction implements Transaction {

    private Date date;
    private double hours;
    private long empId;

    PayrollDatabase payrollDatabase = PayrollDatabase.getPayrollDatabase();

    public AddTimecardTransaction(){}

    public AddTimecardTransaction(Date date, double hours, long empId){
        this.date = date;
        this.hours = hours;
        this.empId = empId;
    }

    public void execute(){
        Employee e = payrollDatabase.getEmployeeById(empId);

        HourlyClassification hourlyClassification = (HourlyClassification) e.getPaymentClassification();
        TimeCard timeCard = new TimeCard(date,hours);
        hourlyClassification.addTimeCard(timeCard);


    }


    public double getHours() {
        return hours;
    }
}
