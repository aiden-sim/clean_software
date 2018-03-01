package part3.implement.transaction;

import part3.implement.classification.HourlyClassification;
import part3.implement.classification.PaymentClassification;
import part3.implement.database.PayrollDatabase;
import part3.implement.entity.Employee;
import part3.implement.entity.TimeCard;

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
            PaymentClassification pc = e.getClassification();
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