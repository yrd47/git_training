package testng;

import org.testng.*;
import org.testng.annotations.Test;

public class TestEmployeeDetails {
	EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
	EmployeeDetails employeeDetails = new EmployeeDetails();

	@Test
	public void testCalculateAppriasal(){
		employeeDetails.setName("yrd");
		employeeDetails.setAge(18);
		employeeDetails.setMonthlySalary(1000000);
		double appraisal = empBusinessLogic.calculateAppaisal(employeeDetails);
		Assert.assertEquals(1000, appraisal,0.0,"1000");
	}
}
