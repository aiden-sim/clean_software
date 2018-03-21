package part4.implement.Schedules;

import part4.implement.PayrollDomain.PayrollSchedule;

import java.util.Calendar;
import java.util.Date;

public class BiweeklySchedule implements PayrollSchedule {

    public boolean isPayDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY && calendar.get(Calendar.WEEK_OF_MONTH)%2 == 0;
    }

    public Date getPayPeriodStartDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-13);
        return calendar.getTime();
    }
}
