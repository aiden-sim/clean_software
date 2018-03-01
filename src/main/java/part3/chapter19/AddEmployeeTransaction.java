package part3.chapter19;

import part3.chapter19.classification.PaymentClassification;
import part3.chapter19.payschedule.PaymentSchedule;

public abstract class AddEmployeeTransaction implements Transaction {

    private int itsEmpid;
    private String itsName;
    private String itsAddress;

    public AddEmployeeTransaction(int itsEmpid, String itsName, String itsAddress) {
        this.itsEmpid = itsEmpid;
        this.itsName = itsName;
        this.itsAddress = itsAddress;
    }

    @Override
    public void execute() {
        PaymentClassification pc = getClassfication();
        PaymentSchedule ps = getSchedule();
        PaymentMethod pm = new HoldMethod();
        Employee e = new Employee(itsEmpid, itsName, itsAddress);
        e.setPaymentClassfication(pc);
        e.setPaymentSchedule(ps);
        e.setPaymentMethod(pm);
        GpayrollDatabase.addEmployee(itsEmpid, e);
    }

    public abstract PaymentSchedule getSchedule();

    public abstract PaymentClassification getClassfication();
}
