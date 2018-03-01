package part3.implement.classification;

import part3.implement.entity.TimeCard;
import part3.implement.payday.PayCheck;
import part3.implement.util.DateUtil;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ZD on 2017/10/24.
 */
public class HourlyClassification implements PaymentClassification {

    private double hourlyPay;
    
    private ConcurrentHashMap<Date,TimeCard> crads = new ConcurrentHashMap<Date, TimeCard>();

    public HourlyClassification(double hourlyRate) {
        this.hourlyPay = hourlyRate;
    }

    public double getHourlyPay() {
        return hourlyPay;
    }

    public void addTimeCard(TimeCard timeCard) {
        crads.put(timeCard.getDate(),timeCard);
    }

    public TimeCard getTimeCard(Date date) {
        return crads.get(date);
    }

    public double calculatePay(PayCheck payCheck) {
        double totalPay = 0.0;
        for (TimeCard timeCard:crads.values()){
            if (DateUtil.IsInPayPeriod(timeCard.getDate(),payCheck.getPayPeriodStartDate(),payCheck.getPayPeriodEndDate()))
                totalPay += calculatePayForTimeCard(timeCard);
        }
        return totalPay;

    }

    private double calculatePayForTimeCard(TimeCard timeCard) {
        double overtimeHours = Math.max(0.0,timeCard.getHours()-8);
        double normalHours = timeCard.getHours() - overtimeHours;
        return hourlyPay*normalHours + hourlyPay*1.5*overtimeHours;

    }
}
