package part3.implement.transaction;

import part3.implement.database.PayrollDatabase;
import part3.implement.entity.Employee;
import part3.implement.payday.PayCheck;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

/**
 * Pay 지급
 */
public class PayDayTransaction implements Transaction {

    private Date date;
    private Hashtable<Integer, PayCheck> paychecks = new Hashtable<Integer, PayCheck>();

    public PayDayTransaction(Date date) {
        this.date = date;
    }

    public void execute() {
        List<Employee> employees = PayrollDatabase.getPayrollDatabase().getAllEmployees();
        for (Employee e : employees) {
            if (e != null) {
                if (e.isPayDate(date)) {
                    Date startDate = e.getPayPeriodSatrtDate(date);
                    PayCheck pc = new PayCheck(startDate, date);
                    paychecks.put(e.getEmpId(), pc);
                    e.payDay(pc);
                }
            }
        }
    }

    public PayCheck getPayCheck(int empId) {
        return paychecks.get(empId);
    }
}
