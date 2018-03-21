package part4.implement.PayrollDomain;

import java.util.Date;

public interface PayrollSchedule {
    boolean isPayDate(Date date);

    Date getPayPeriodStartDate(Date date);
}
