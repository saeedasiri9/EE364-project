package departments_employees;

import java.util.*;

public class governmentalTreatment {

	private ArrayList<Department> Department = new ArrayList<>();
	private ArrayList<String> History = new ArrayList<>();
	private double RequiredTime;
	private int ID;
	private double ProductionPercent = 0;
	private double ErrorPercent = 0;
	private double ActualTime = 0;

	public governmentalTreatment() { // governmentalTreatment constructor create all the departments and hire all the employees for the departments

		ArrayList<Employee> AccEmployees = new ArrayList<Employee>();
		AccountingDepartment department1 = new AccountingDepartment(AccEmployees);
		department1.HireEmployees();
		this.Department.add(department1);

		ArrayList<Employee> SafetyEmployees = new ArrayList<Employee>();
		SafetyDepartment department2 = new SafetyDepartment(SafetyEmployees);
		department2.HireEmployees();
		this.Department.add(department2);

		ArrayList<Employee> LawEmployees = new ArrayList<Employee>();
		LawDepartment department3 = new LawDepartment(LawEmployees);
		department3.HireEmployees();
		this.Department.add(department3);

		ArrayList<Employee> ProdEmployees = new ArrayList<Employee>();
		ProductionDepartment department4 = new ProductionDepartment(ProdEmployees);
		department4.HireEmployees();
		this.Department.add(department4);

		ArrayList<Employee> MarkEmployees = new ArrayList<Employee>();
		MarketingDepartment department5 = new MarketingDepartment(MarkEmployees);
		department5.HireEmployees();
		this.Department.add(department5);

		ArrayList<Employee> RecEmployees = new ArrayList<Employee>();
		ReceptionDepartment department6 = new ReceptionDepartment(RecEmployees);
		department6.HireEmployees();
		this.Department.add(department6);

		ArrayList<Employee> DevEmployees = new ArrayList<Employee>();
		DevelopmentDepartment department7 = new DevelopmentDepartment(DevEmployees);
		department7.HireEmployees();
		this.Department.add(department7);

		ArrayList<Employee> CosSerEmployees = new ArrayList<Employee>();
		CostumerServiceDepartment department8 = new CostumerServiceDepartment(CosSerEmployees);
		department8.HireEmployees();
		this.Department.add(department8);

		ArrayList<Employee> FinanEmployees = new ArrayList<Employee>();
		FinancialDepartment department9 = new FinancialDepartment(FinanEmployees);
		department9.HireEmployees();
		this.Department.add(department9);

		ArrayList<Employee> HREmployees = new ArrayList<Employee>();
		HRDepartment department10 = new HRDepartment(HREmployees);
		department10.HireEmployees();
		this.Department.add(department10);

	}

	public void DepartmentsSelected() { // Method to select a number of department that will work on the governmental treatment

		Random rand = new Random();

		int Num_Dep_Removed = rand.nextInt(9) + 1;  // random number of departments

		Collections.shuffle(Department);

		for (int i = 1; i <= Num_Dep_Removed; i++) {

			Department.remove(0);

		}

		for (int i = 0; i < Department.size(); i++) { // To set the production percentage for each department

			Department.get(i).setD_ProductionPercent(Math.round(100 / Department.size()));

		}

	}
	// setters and getters for Department, RequiredTime, ActualTime, ProductionPercent, History, ErrorPercent, and ID
	public ArrayList<Department> getDepartment() {
		return Department;
	}

	public void setDepartment(ArrayList<Department> department) {
		Department = department;
	}

	public double getRequiredTime() {
		return RequiredTime;
	}

	public void setRequiredTime(double requiredTime) {
		RequiredTime = requiredTime;
	}

	public double getActualTime() {
		return ActualTime;
	}

	public void setActualTime(double actualTime) {
		ActualTime = actualTime;
	}

	public void setProductionPercent(double d) {
		ProductionPercent = d;
	}

	public ArrayList<String> getHistory() {
		return History;
	}

	public void setHistory(ArrayList<String> history) {
		History = history;
	}

	public double getProductionPercent() {
		return ProductionPercent;
	}

	public double getErrorPercent() {
		return ErrorPercent;
	}

	public void setErrorPercent(double errorPercent) {
		ErrorPercent = errorPercent;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String toString() { // to string to print out the ID, History, RequiredTime, ActualTime, ProductionPercent, and ErrorPercent

		return "ID: " + getID() + "\n" + "History: " + getHistory() + "\n" + "RequiredTime: " + getRequiredTime() + "\n"
				+ "ActualTime: " + getActualTime() + "\n" + "ProductionPercent: " + getProductionPercent() + "\n"
				+ "ErrorPercent: " + getErrorPercent() + "\n";

	}

	public boolean checkCompletionError() {
		return ProductionPercent > 100;
	}

}