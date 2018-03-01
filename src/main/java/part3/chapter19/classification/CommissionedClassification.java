package part3.chapter19.classification;

import part3.chapter19.SalesReceipt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CommissionedClassification implements PaymentClassification {

    private double salary;
    private double commissionRate;
    private List<SalesReceipt> salesReceiptList;

    public CommissionedClassification(double salary, double commissionRate) {
        this.salary = salary;
        this.commissionRate = commissionRate;
        salesReceiptList = new ArrayList<SalesReceipt>();
    }

    public void addSalesReceipt(SalesReceipt salesReceipt) {
        salesReceiptList.add(salesReceipt);
    }

    public SalesReceipt getSalesReceipt(LocalDate date) {
        for (SalesReceipt salesReceipt : salesReceiptList) {
            if (salesReceipt.getDate().equals(date)) {
                return salesReceipt;
            }
        }
        return null;
    }

    @Override
    public double getSalary() {
        int totalMoney = 0;
        for (SalesReceipt salesReceipt : salesReceiptList) {
            totalMoney += salesReceipt.getAmount();
        }
        return totalMoney * commissionRate + salary;
    }
}
