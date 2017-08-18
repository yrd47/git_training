package programme_3;

/**
 * Created by yrd on 2017/5/10.
 */
public class MaxMin {

    public static Employee findMax(Employee[] employees){
        Employee max = employees[0];
        for(int i=1;i<employees.length;i++){
            if(employees[i].getSalary() > max.getSalary()){
                max = employees[i];
            }
        }
        return max;
    }

    public static Employee findMin(Employee[] employees){
        Employee min = employees[0];
        for(int i=1;i<employees.length;i++){
            if(employees[i].getSalary() < min.getSalary()){
                min = employees[i];
            }
        }
        return min;
    }

    public static void main(String[] args){
        String[] names = {"赵云", "黄忠", "典韦", "许褚", "张飞", "马超", "曹仁", "甘宁"};
        Employee[] employees = new Employee[names.length];
        for (int i=0; i<employees.length;i++){
            int salary = (int)(Math.random() * 4001 +1000);
            employees[i] = new Employee(names[i],salary);
            System.out.println(employees[i]);
        }
        Employee wealthy = findMax(employees);
        Employee cockwire = findMin(employees);
        System.out.println(wealthy);
        System.out.print(cockwire);
    }
}
