package part4.implement.ClassificationTransaction;

import part4.implement.TransactionApplication.Transaction;
import part4.implement.Classifications.HourlyClassification;
import part4.implement.PayrollDomain.PayrollClassification;
import part4.implement.PayrollDatabase.PayrollDatabase;
import part4.implement.PayrollDomain.Employee;
import part4.implement.Classifications.TimeCard;

import java.util.Date;

/**
 * 타임기록(타임카드) 트랜잭션
 */
public class TimeCardTransaction implements Transaction {
    private Date itsDate;
    private double itsHours;
    private int itsEmpId;

    public TimeCardTransaction(Date date, double hours, int empId) {
        this.itsDate = date;
        this.itsHours = hours;
        this.itsEmpId = empId;
    }

    public void execute() throws Exception {
        Employee e = PayrollDatabase.getPayrollDatabase().getEmployee(itsEmpId);
        if (e != null) {
            PayrollClassification pc = e.getClassification();
            if (pc instanceof HourlyClassification) {
                HourlyClassification hc = (HourlyClassification) pc;
                hc.addTimeCard(new TimeCard(itsDate, itsHours));
            } else {
                throw new Exception("Tried to add timecard to non-hourly employee");
            }
        } else {
            throw new Exception("No such employee.");
        }
    }
}