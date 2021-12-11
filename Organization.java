package departments_employees;

import java.util.*;

public class Organization {
	private static ArrayList<governmentalTreatment> NewGovernmentalTreatments = new ArrayList<>();
	private static ArrayList<governmentalTreatment> GovernmentalTreatments = new ArrayList<>();
	private static ArrayList<governmentalTreatment> CompletedGovernmentalTreatments = new ArrayList<>();

	public static void main(String[] args) {

		System.out.println("Start of Simulation" + "\n");

		Random rand = new Random();

		int Num_of_Gov = 0; // Number of governmental treatment
		ArchiveDepartment archive = new ArchiveDepartment(); // creating object from the archive class
		char ans1 = 'y';
		int HeWantYearReport = 0;

		for (int day = 1; day <= 360; day++) { // Simulation Loop
			Scanner scan = new Scanner(System.in);

			if (HeWantYearReport == 1) {
				ans1 = 'y';
			}

			else if (HeWantYearReport == 0) {
				System.out.println("Do you want to continue the simulation? Enter Y or N ");
				ans1 = scan.nextLine().charAt(0);
				while (true) {
					if (ans1 != 'y' && ans1 != 'Y' && ans1 != 'N' && ans1 != 'n') {
						System.out.println("plese enter ether Y or N");
						ans1 = scan.nextLine().charAt(0);
					}

					else
						break;

				}
			}

			if (ans1 == 'y' || ans1 == 'Y') {

				System.out.println("Day " + day + ":" + "\n");

				int NewNumberOfGovernmentalTreatment = rand.nextInt(4) + 1;// Random number of governmental treatment for each day

				for (int c = 1; c <= NewNumberOfGovernmentalTreatment; c++) { // loop to create objects of governmental Treatment Based from the random number
																				
					governmentalTreatment gt = new governmentalTreatment();

					Num_of_Gov++;

					gt.setID(Num_of_Gov); // setting all governmental treatment ID's

					gt.DepartmentsSelected(); // select random departments form the governmental treatment

					gt.setRequiredTime(gt.getDepartment().size()); // Setting the required time for the governmental treatment to be done with
					gt.setActualTime(gt.getRequiredTime()); // Setting the default of the actual time for the governmental treatment to be done with

					for (int i = 0; i < gt.getDepartment().size(); i++) { /* loop to get the completion percent for each department
                                                                          and to give each employee in a certain department a completion percent */
						for (int j = 0; j < gt.getDepartment().get(i).Employee.size(); j++) {

							Department GDepartment = gt.getDepartment().get(i);
							double GDepartmentProd = GDepartment.getD_ProductionPercent();
							Employee GDepartmentEmployee = GDepartment.Employee.get(j);
							double GDepartmentEmpSize = GDepartment.Employee.size();
							double EmpProd = GDepartmentProd / GDepartmentEmpSize;
							GDepartmentEmployee.setCompletionPercent(EmpProd);

						}

					}

					NewGovernmentalTreatments.add(gt); // adding the governmental treatment objects to the NewGovernmentalTreatments Arraylist

				}

				for (int i = 0; i < NewGovernmentalTreatments.size(); i++) {

					GovernmentalTreatments
							.add(NewGovernmentalTreatments.get(i)); /*
																	 * take the governmental treatments in the array
																	 * list (NewGovernmentalTreatments) // and puts them
																	 * in the array list GovernmentalTreatments
																	 */

				}

				NewGovernmentalTreatments.clear(); // clearing the NewGovernmentalTreatments Array list for this day

				for (int hour = 0; hour < 9; hour++) { // Day loop of working 9 hours

					for (int n = 0; n < GovernmentalTreatments.size(); n++) { /* loop to get the Error percent of each Employee working in the governmental treatment
						                                                                  and add the percentage to the governmental treatment */
						double GovTE = GovernmentalTreatments.get(n).getErrorPercent();
						governmentalTreatment GovT1 = GovernmentalTreatments.get(n);
						Department G1Department = GovT1.getDepartment().get(0);
						Employee G1DepartmentEmployee = G1Department.Employee.get(hour);
						double EEpercentage = G1DepartmentEmployee.getMistakePercent();
						GovT1.setErrorPercent(GovTE += (int) EEpercentage);

						if (!(GovernmentalTreatments.get(n).getProductionPercent() >= 99)) { // Adding to the governmental treatment production percent from each employee

							governmentalTreatment GovT2 = GovernmentalTreatments.get(n);

							double GovTP = GovT2.getProductionPercent();

							Department G2Department = GovT2.getDepartment().get(0);

							Employee G2DepartmentEmployee = G2Department.Employee.get(hour);

							double EPpercentage = G2DepartmentEmployee.getCompletionPercent();

							GovT2.setProductionPercent(GovTP + EPpercentage);
							
							for(int i = 0; i < GovernmentalTreatments.size(); i++) {
								
								if(GovernmentalTreatments.get(i).getProductionPercent() > 100)
									
								Math.floor(GovernmentalTreatments.get(i).getProductionPercent());
									
							}

						}
					}

				}

				for (int i = 0; i < GovernmentalTreatments.size(); i++) { // loop to get the history of each governmental treatment

					governmentalTreatment GT = GovernmentalTreatments.get(i);

					ArrayList<String> history = GT.getHistory();

					history.add(GT.getDepartment().get(0).toString());

				}

				for (int n = 0; n < GovernmentalTreatments.size(); n++) { // loop to print the information for the governmental treatment

					System.out.println("Governmental Treatment ID: " + GovernmentalTreatments.get(n).getID() + "\n");

					System.out
							.println("History of the Treatment: " + GovernmentalTreatments.get(n).getHistory() + "\n");

					System.out.println("Completion Percentage: " + GovernmentalTreatments.get(n).getProductionPercent()
							+ " %" + "\n");

					System.out.println(
							"Error Percentage: " + GovernmentalTreatments.get(n).getErrorPercent() + " %" + "\n");

					System.out.println("Number of Departments left: "
							+ (GovernmentalTreatments.get(n).getDepartment().size() - 1) + " Departments " + "\n");

					System.out.println("---------------------------------" + (n + 1)
							+ "--------------------------------------" + "\n");

				}

				checkIfDone(); // calling CheckIfDone method to check if the a certain governmental treatment is done (go to the end of the main class to see the method)

				
	}

	private static void checkIfDone() {

		for (int i = 0; i < GovernmentalTreatments.size(); i++) {

			if (GovernmentalTreatments.get(i).getDepartment().size() > 1) {

				GovernmentalTreatments.get(i).getDepartment().remove(0);

			} else if (GovernmentalTreatments.get(i).getDepartment().size() == 1) {

				CompletedGovernmentalTreatments.add(GovernmentalTreatments.get(i));
				GovernmentalTreatments.remove(i);

			}

		}
	}
}