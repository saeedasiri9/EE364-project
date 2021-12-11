package departments_employees;

import java.util.*;

public class HRDepartment extends Department {

	public HRDepartment(ArrayList<departments_employees.Employee> Employee) {
		super(Employee);

	}

	public void HireEmployees() {// an override from the method in the Department class

		Random rand = new Random();

		int NumberOfEmployee = 9; // Random number of employees
		for (int i = 1; i <= NumberOfEmployee; i++) {
			Employee employee = new Employee();// creating employee objects based on number of employee
			employee.setMistakePercent(rand.nextInt(2) + 0.1);
			Employee.add(employee); // add the employee objects to the arraylist

		}

		for (int i = 0; i < Employee.size(); i++) { // loop to set time per employee 

			Employee.get(i).setTimePerEmployee(9f / Employee.size());

		}

	}

	public String toString() {

		return "HRDepartment";

	}
}
