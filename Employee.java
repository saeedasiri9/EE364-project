package departments_employees;

import java.util.ArrayList;
import java.util.Random;

public class Employee {

	private double MistakePercent; // every employee has a mistake percentage
	private double TimePerEmployee; // Time for employee to finish his task
	private double CompletionPercent; // completion percent for employee

	public Employee() {

	}
	//Setters and Getters for MistakePercent, TimePerEmployee, and CompletionPercent
	public double getMistakePercent() {
		return MistakePercent;
	}

	public void setMistakePercent(double d) {
		MistakePercent = d;
	}

	public double getTimePerEmployee() {
		return TimePerEmployee;
	}

	public void setTimePerEmployee(double timePerEmployee) {
		TimePerEmployee = timePerEmployee;
	}

	public double getCompletionPercent() {
		return CompletionPercent;
	}

	public void setCompletionPercent(double completionPercent) {
		CompletionPercent = completionPercent;
	}

	public void addTimePerEmployee(int T) {
		TimePerEmployee = TimePerEmployee + T;
	}

	public void addCompletionPercent(int P) {
		CompletionPercent = CompletionPercent + P;
	}

	public String toString() {

		return "Employee   " + +getMistakePercent() + "     " + getCompletionPercent() + "        "
				+ getTimePerEmployee() + "\n\n";

	}
}
