package part4.implement.Classifications;

import java.util.Date;

/**
 * 영수증
 */
public class SalesReceipt {
    private Date itsDate;
    private int itsAmount;

    public SalesReceipt(Date date, int amount) {
        this.itsDate = date;
        this.itsAmount = amount;
    }

    public Date getItsDate() {
        return itsDate;
    }

    public int getItsAmount() {
        return itsAmount;
    }
}
