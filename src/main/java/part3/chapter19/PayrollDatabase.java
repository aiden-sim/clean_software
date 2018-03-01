package part3.chapter19;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {
    private Map<Integer, Employee> itsEmployees;

    public PayrollDatabase() {
        itsEmployees = new HashMap<Integer, Employee>();
    }

    public Employee getEmployee(int empid) {
        return itsEmployees.get(empid);
    }

    public void addEmployee(int empid, Employee e) {
        itsEmployees.put(empid, e);
    }

    public void deleteEmployee(int empid) {
        itsEmployees.remove(empid);
    }
}
