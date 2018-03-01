package part3.implement.entity;

import java.util.Date;

/**
 * 타임카드
 */
public class TimeCard {
    private Date itsDate;
    private double itsHours;

    public TimeCard(Date date, double hours) {
        this.itsDate = date;
        this.itsHours = hours;
    }

    public Date getDate() {
        return itsDate;
    }

    public double getHours() {
        return itsHours;
    }
}
