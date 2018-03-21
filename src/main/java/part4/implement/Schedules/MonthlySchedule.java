package part4.implement.Schedules;

import part4.implement.PayrollDomain.PayrollSchedule;
import part4.implement.util.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * 그 날짜가 마지막 날인 경우만 true로 반환
 */
public class MonthlySchedule implements PayrollSchedule {
    public boolean isPayDate(Date date) {
        return DateUtil.isMonthDay(date);
    }

    public Date getPayPeriodStartDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        while (calendar.get(Calendar.MONTH) == month){
            calendar.add(Calendar.DATE,-1);
        }
        return calendar.getTime();
    }
}
