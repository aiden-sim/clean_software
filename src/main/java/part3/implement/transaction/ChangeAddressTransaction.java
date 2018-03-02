package part3.implement.transaction;

import part3.implement.entity.Employee;

/**
 * 직원 주소 변경
 */
public class ChangeAddressTransaction extends ChangeEmployeeTransaction {
    private String address;

    public ChangeAddressTransaction(int empId, String address) {
        super(empId);
        this.address = address;
    }

    public void change(Employee e) {
        e.setAddress(address);
    }
}
