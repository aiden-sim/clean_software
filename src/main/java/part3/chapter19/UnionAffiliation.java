package part3.chapter19;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UnionAffiliation implements Affiliation {
    private int memberId;
    private double charge;
    private List<ServiceCharge> serviceChargeList;

    public UnionAffiliation(int memberId, double charge) {
        this.memberId = memberId;
        this.charge = charge;
        serviceChargeList = new ArrayList<ServiceCharge>();
    }

    public void addServiceCharge(LocalDate date, double charge) {
        ServiceCharge serviceCharge = new ServiceCharge(date, charge);
        serviceChargeList.add(serviceCharge);
    }

    public ServiceCharge getServiceCharge(LocalDate date) {
        for (ServiceCharge charge : serviceChargeList) {
            if (charge.getDate().equals(date)) {
                return charge;
            }
        }
        return null;
    }
}
