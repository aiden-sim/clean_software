package part3.implement.affiliation;

import part3.implement.entity.ServiceCharge;
import part3.implement.payday.PayCheck;
import part3.implement.util.DateUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 노동조합
 */
public class UnionAffiliation implements Affiliation {
    private int memberID;
    private double mDues;
    private ConcurrentHashMap<Date, ServiceCharge> serviceCharges = new ConcurrentHashMap<Date, ServiceCharge>();

    public UnionAffiliation(int memberID, double mDues) {
        this.mDues = mDues;
        this.memberID = memberID;
    }

    public double getmDues() {
        return mDues;
    }

    public int getMemberID() {
        return memberID;
    }

    public ServiceCharge getServiceCharge(Date date) {
        return serviceCharges.get(date);
    }

    public void addServiceCharge(ServiceCharge serviceCharge) {
        serviceCharges.put(serviceCharge.getDate(), serviceCharge);
    }


    /**
     * 금요일 횟수 계산
     */
    private int NumberOfFridaysInPayPeriod(Date payPeriodStartDate, Date payPeriodEndDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(payPeriodStartDate);
        Calendar payPeriodEnd = Calendar.getInstance();
        payPeriodEnd.setTime(payPeriodEndDate);

        int firdays = 0;
        while (calendar.before(payPeriodEnd)) {
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                firdays++;
            }
            calendar.add(Calendar.DATE, 1);
        }
        return firdays;
    }

    /**
     * 조합비 계산
     */
    public double calculateDeductions(PayCheck payCheck) {
        double totalDues = 0;

        int fridays = NumberOfFridaysInPayPeriod(payCheck.getPayPeriodStartDate(), payCheck.getPayPeriodEndDate());
        totalDues = mDues * fridays;

        // 공제액 합
        for (ServiceCharge charge : serviceCharges.values()) {
            if (DateUtil.IsInPayPeriod(charge.getDate(), payCheck.getPayPeriodStartDate(), payCheck.getPayPeriodEndDate()))
                totalDues += charge.getAmount();
        }

        return totalDues;
    }

}
