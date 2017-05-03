package testng;

public class EmpBusinessLogic {

	public double calculateYearSalary(EmployeeDetails employeeDetails){
		double yearSalary = 0;
		yearSalary = employeeDetails.getMonthlySalary() * 12;
		return yearSalary;
	}
	
	public double calculateAppaisal(EmployeeDetails employeeDetails){
		double appraisal = 0;
		if (employeeDetails.getMonthlySalary() < 10000){
			appraisal = 500;
		}else{
			appraisal = 1000;
		}
		return appraisal;
	}
}
