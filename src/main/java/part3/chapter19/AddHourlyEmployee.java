package part3.chapter19;

import part3.chapter19.classification.HourlyClassification;
import part3.chapter19.classification.PaymentClassification;
import part3.chapter19.payschedule.PaymentSchedule;
import part3.chapter19.payschedule.WeeklySchedule;

public class AddHourlyEmployee extends AddEmployeeTransaction {

    private double hourlyRate;

    public AddHourlyEmployee(int itsEmpid, String itsName, String itsAddress, double hourlyRate) {
        super(itsEmpid, itsName, itsAddress);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new WeeklySchedule();
    }

    @Override
    public PaymentClassification getClassfication() {
        return new HourlyClassification(hourlyRate);
    }
}
