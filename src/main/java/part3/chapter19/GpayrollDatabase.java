package part3.chapter19;

import java.util.HashMap;
import java.util.Map;

public class GpayrollDatabase {
    private static PayrollDatabase payrollDatabase = new PayrollDatabase();

    private static Map<Integer, Employee> unionMemberMap = new HashMap<Integer, Employee>();

    public static void addEmployee(int empid, Employee e) {
        payrollDatabase.addEmployee(empid, e);
    }

    public static Employee getEmployee(int empid) {
        return payrollDatabase.getEmployee(empid);
    }

    public static void deleteEmployee(int empId) {
        payrollDatabase.deleteEmployee(empId);
    }

    public static void AddUnionMember(int memberId, Employee e) {
        unionMemberMap.put(memberId, e);
    }

    public static Employee getUnionMember(int memberId) {
        return unionMemberMap.get(memberId);
    }
}
