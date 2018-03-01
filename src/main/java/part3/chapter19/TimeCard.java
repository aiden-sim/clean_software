package part3.chapter19;

import java.time.LocalDate;

public class TimeCard {
    private double itsHours;
    private LocalDate data;

    public TimeCard(LocalDate data, double itsHours) {
        this.data = data;
        this.itsHours = itsHours;
    }

    public double getHours() {
        return itsHours;
    }

    public LocalDate getData() {
        return data;
    }
}
