package part4.implement.Classifications;

import part4.implement.PayrollDomain.PayrollClassification;
import part4.implement.Payday.PayCheck;
import part4.implement.util.DateUtil;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 임금 지금방식 (영업)
 */
public class CommissionedClassification implements PayrollClassification {

    private double salaryBase;
    private double commissionRate;

    private ConcurrentHashMap<Date, SalesReceipt> salesReceipts = new ConcurrentHashMap<Date, SalesReceipt>();

    public CommissionedClassification(double salaryBase, double commissionRate) {
        this.salaryBase = salaryBase;
        this.commissionRate = commissionRate;
    }

    public void addSalesReceipt(SalesReceipt salesReceipt) {
        salesReceipts.put(salesReceipt.getItsDate(), salesReceipt);
    }

    public SalesReceipt getSalesReceipt(Date date) {
        return salesReceipts.get(date);
    }

    public double calculatePay(PayCheck pc) {
        double commission = 0.0;
        for (SalesReceipt sr : salesReceipts.values()) {
            if (DateUtil.between(sr.getItsDate(), pc.getPayPeriodStartDate(), pc.getPayPeriodEndDate())) {
                commission += sr.getItsAmount() * commissionRate;
            }
        }
        return salaryBase + commission;
    }
}
