package departments_employees;

import java.util.*;

public class Department {

	protected ArrayList<Employee> Employee = new ArrayList<Employee>();

	protected double D_ProductionPercent;

	public Department(ArrayList<departments_employees.Employee> employee) {
		super();
		Employee = employee;

	}

	public void HireEmployees() { // Method to hire employees in each department

		Random rand = new Random();

		int NumberOfEmployee = rand.nextInt(10) + 10; // Random number of employees
		for (int i = 1; i <= NumberOfEmployee; i++) {
			Employee employee = new Employee();// creating employee objects based on number of employee
			employee.setMistakePercent(rand.nextInt(21));
			Employee.add(employee); // add the employee objects to the array list

		}
		int Num_Emp_Removed = rand.nextInt(Employee.size()); // number of employees removed
		Collections.shuffle(Employee);                      //after we shuffle the array list

		for (int i = 0; i <= Num_Emp_Removed; i++) {

			Employee.remove(0);

		}

		for (int i = 0; i < Employee.size(); i++) { // loop to set time per employee 

			Employee.get(i).setTimePerEmployee(9f / Employee.size());

		}

	}
	
	// Setters and getters for Department ProductionPercent, and Employee Array list

	public double getD_ProductionPercent() {
		return D_ProductionPercent;
	}

	public void setD_ProductionPercent(double d_ProductionPercent) {
		D_ProductionPercent = d_ProductionPercent;
	}

	public ArrayList<Employee> getEmployee() {
		return Employee;
	}

	public void setEmployee(ArrayList<Employee> employee) {
		Employee = employee;
	}

	public String toString() {

		return "Department";

	}

}
