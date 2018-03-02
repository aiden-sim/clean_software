package part3.implement.schedule;

import java.util.Date;

public interface PaymentSchedule {
    boolean isPayDate(Date date);

    Date getPayPeriodStartDate(Date date);
}
