package part4.implement.Schedules;

import part4.implement.PayrollDomain.PayrollSchedule;
import part4.implement.util.DateUtil;

import java.util.Calendar;
import java.util.Date;

public class WeeklySchedule implements PayrollSchedule {


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
