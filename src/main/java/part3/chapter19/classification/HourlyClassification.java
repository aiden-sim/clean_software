package part3.chapter19.classification;

import part3.chapter19.TimeCard;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HourlyClassification implements PaymentClassification {

    private double hourlyRate;
    private List<TimeCard> timeCardList;

    public HourlyClassification(double hourlyRate) {
        this.hourlyRate = hourlyRate;
        timeCardList = new ArrayList<TimeCard>();
    }

    public void addTimeCard(TimeCard timeCard) {
        timeCardList.add(timeCard);
    }

    public TimeCard getTimeCard(LocalDate date) {
        for (TimeCard timeCard : timeCardList) {
            if (timeCard.getData().equals(date)) {
                return timeCard;
            }
        }
        return null;
    }

    @Override
    public double getSalary() {
        int totalHour = 0;
        for (TimeCard timeCard : timeCardList) {
            totalHour += timeCard.getHours();
        }
        return totalHour * hourlyRate;
    }
}
