package part4.implement.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 시간 유틸
 */
public class DateUtil {
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static boolean IsInPayPeriod(Date date, Date payPeriodStartDate, Date payPeriodEndDate) {
        return (date.after(payPeriodStartDate)) && (date.before(payPeriodEndDate));
    }

    /**
     * 일반직원 월급 (달의 마지막날 체크)
     */
    public static boolean isMonthDay(Date date) {
        if (date == null)
            return false;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date date1 = calendar.getTime();
        if (date.compareTo(date1) == 0)
            return true;
        return false;
    }

    /**
     * 알바,영업 주급 (주의 금요일 체크)
     */
    public static boolean isWeekDay(Date date) {
        if (date == null)
            return false;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (day == 6)
            return true;
        return false;
    }

    /**
     * String to Date
     */
    public static Date getDateFormat(String date) {
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean between(Date d, Date date1, Date date2) {
        return d.after(date1) && d.before(date2);
    }
}
