package part3.implement.schedule;

import part3.implement.util.DateUtil;

import java.util.Calendar;
import java.util.Date;

public class WeeklySchedule implements PaymentSchedule {


    public boolean isPayDate(Date date) {
        return DateUtil.isWeekDay(date);
    }

    public Date getPayPeriodStartDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-6);
        return calendar.getTime();
    }
}
