package part3.implement.entity;

import java.util.Date;

/**
 * 조합 부과액
 */
public class ServiceCharge {

    private Date date;
    private double amount;

    public ServiceCharge(){}

    public ServiceCharge(Date date,double amount){
        this.amount = amount;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
}
