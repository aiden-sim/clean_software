package part3.implement.classification;

import part3.implement.entity.TimeCard;
import part3.implement.payday.PayCheck;
import part3.implement.util.DateUtil;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 임금 지금방식 (알바)
 */
public class HourlyClassification implements PaymentClassification {

    private double itsRate;

    private ConcurrentHashMap<Date, TimeCard> map = new ConcurrentHashMap<Date, TimeCard>();

    public HourlyClassification(double rate) {
        this.itsRate = rate;
    }

    public double getRate() {
        return itsRate;
    }

    public void addTimeCard(TimeCard timeCard) {
        map.put(timeCard.getDate(), timeCard);
    }

    public TimeCard getTimeCard(Date date) {
        return map.get(date);
    }

    public double calculatePay(PayCheck pc) {
        double totalPay = 0.0;

        for (TimeCard timeCard : map.values()) {
            if (DateUtil.IsInPayPeriod(timeCard.getDate(), pc.getPayPeriodStartDate(), pc.getPayPeriodEndDate()))
                totalPay += calculatePayForTimeCard(timeCard);
        }
        return totalPay;
    }

    private double calculatePayForTimeCard(TimeCard timeCard) {
        double overtimeHours = Math.max(0.0, timeCard.getHours() - 8);
        double normalHours = timeCard.getHours() - overtimeHours;
        return itsRate * normalHours + itsRate * 1.5 * overtimeHours;
    }
}
