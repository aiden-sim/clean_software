package part3.implement.database;

import part3.implement.entity.Employee;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 퍼사드 패턴
 */
public class PayrollDatabase {
    private static PayrollDatabase payrollDatabase = new PayrollDatabase();

    private ConcurrentHashMap<Integer, Employee> employees = new ConcurrentHashMap<Integer, Employee>();       // 직원
    private ConcurrentHashMap<Integer, Employee> unionMembers = new ConcurrentHashMap<Integer, Employee>();    // 조합원

    public static PayrollDatabase getPayrollDatabase() {
        return payrollDatabase;
    }

    // 직원
    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    public void addEmployee(int empId, Employee e) {
        employees.put(empId, e);
    }

    public void deleteEmployeeById(int id) {
        employees.remove(id);
    }


    // 조합원
    public Employee getEmployeeByMemberId(int memberId) {
        return unionMembers.get(memberId);
    }

    public void addUnionMember(int memberId, Employee e) {
        unionMembers.put(memberId, e);
    }

    public void deleteUnionMember(int memberId) {
        unionMembers.remove(memberId);
    }

    public ArrayList<Employee> getAllEmployees() {
        return new ArrayList<Employee>(employees.values());
    }
}
