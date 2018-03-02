package part3.implement.transaction;

import part3.implement.entity.Employee;

/**
 * 직원 이름 변경
 */
public class ChangeNameTransaction extends ChangeEmployeeTransaction {
    private String name;

    public ChangeNameTransaction(int empId, String name) {
        super(empId);
        this.name = name;
    }

    public void change(Employee e) {
        e.setName(name);
    }
}
