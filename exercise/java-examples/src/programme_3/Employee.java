package programme_3;

/**
 * 员工类
 * Created by yrd on 2017/5/10.
 */
public class Employee {
    private String name;
    private double salary;

    public Employee(String name,double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }

    public String toString(){
        return name + " : " + salary;
    }
}
