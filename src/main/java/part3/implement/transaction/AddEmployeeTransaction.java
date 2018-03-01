package part3.implement.transaction;

import part3.implement.classification.PaymentClassification;
import part3.implement.database.PayrollDatabase;
import part3.implement.entity.Employee;
import part3.implement.method.HoldMethod;
import part3.implement.method.PaymentMethod;
import part3.implement.schedule.PaymentSchedule;

/**
 *采用模板模式实现
 * Created by ZD on 2017/10/24.
 */
public abstract class AddEmployeeTransaction implements Transaction {

    private long id;
    private String name;
    private String address;

    public AddEmployeeTransaction(){}

    public AddEmployeeTransaction(long empid,String name,String address){
        this.id = empid;
        this.name = name;
        this.address = address;
    }

    public void execute(){
        PaymentClassification pc = getClassification();
        PaymentSchedule ps = getSchdule();
        PaymentMethod pm = getMethod();
        Employee e = new Employee(id,name,address);
        e.setClassification(pc);
        e.setSchedule(ps);
        e.setMethod(pm);


        PayrollDatabase.getPayrollDatabase().addEmployee((int) id,e);

    }

    protected PaymentMethod getMethod(){
        return new HoldMethod();
    }

    protected abstract PaymentSchedule getSchdule();

    protected abstract PaymentClassification getClassification();

}
