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

				for (int i = 0; i < CompletedGovernmentalTreatments.size(); i++) { /* loop to store all the finished governmental treatment in Archive
				                                                                                                 	and to remove it from CompletedGovernmentalTreatments Arraylist */
					archive.getArchiveOfGovernmentalTreatment().add(CompletedGovernmentalTreatments.get(i));
					CompletedGovernmentalTreatments.remove(i);
				}

				for (int i = 0; i < archive.getArchiveOfGovernmentalTreatment().size(); i++) { /* the Actual time for the governmental treatment 
					                                                                                                      will be increased based on the error percentage */
					
					if (archive.getArchiveOfGovernmentalTreatment().get(i).getErrorPercent() != 0) { // the archive will work on their governmental treatment that have errors

						archive.ArchMethod(archive.getArchiveOfGovernmentalTreatment().get(i));

						double Time = archive.getArchiveOfGovernmentalTreatment().get(i).getActualTime() + 1; // the actual time for the governmental treatment will be increased

						archive.getArchiveOfGovernmentalTreatment().get(i).setActualTime(Time); // set the actual time after the increase

					}

					else if (archive.getArchiveOfGovernmentalTreatment().get(i).getErrorPercent() == 0) { /* if there are no errors in the governmental treatment the program will apply the PrintArch method
					                                                                                      to the governmental treatment and will remove it from the ArchiveOfGovernmentalTreatment array list 
					                                                                                      and add it to the CompleteArchiveOfGovernmentalTreatment array list in the archive department class*/
						governmentalTreatment Gov = archive.getArchiveOfGovernmentalTreatment().get(i);
						archive.PrintArch(Gov); //see the method in archive class to know more about it
						archive.getCompleteArchiveOfGovernmentalTreatment().add(Gov);
						archive.getArchiveOfGovernmentalTreatment().remove(i);
					}

				}

				TableViewer table = new TableViewer(archive.getIndexArchiveOfGovernmentalTreatment(), // Creating object from the TableViewer class 
						archive.getIDArchiveOfGovernmentalTreatment());                                         // and give it the index of governmental treatment and ID in the archive

				if ((archive.getCompleteArchiveOfGovernmentalTreatment().size() != 0) && (HeWantYearReport == 0)) {
					int ans2 = 2;

					do { // after finishing the first governmental treatment, the user will be asked if he wants to check it from the archive

						System.out.println(
								"Do you want to check the archive for a Governmental Treatment you want?: Enter Y if yes , N if no "
										+ "\n");

						String ans3 = scan.next();
						;

						if (ans3.equals("y") || ans3.equals("Y")) {

							table.viewTable(10, 10); // To show the user all the governmental treatment in archive by ID

							System.out.println("Pick your Governmental Treatment by ID: " + "\n");
							try {
								ans2 = scan.nextInt();
							} catch (Exception e) {
								System.out.println("Sorry, wrong input the program will shutdown" + "\n");
								System.exit(0);
							}
							for (int i = 0; i < archive.getCompleteArchiveOfGovernmentalTreatment().size(); i++) {

								governmentalTreatment ArchGov = archive.getCompleteArchiveOfGovernmentalTreatment().get(i);

								if (ArchGov.getID() == ans2) {

									System.out.println(ArchGov);

								} else
									continue;

							}

						} else if (ans3.equals("n") || ans3.equals("N")) // if the user don't want to continue the simulation
							break;
						else {
							System.out.println(
									"Sorry you entered wrong input, The program will skip this Quesion" + "\n");
							break;
						}

					} while (true);

				} else
					System.out.println("There are no Complete Govermental Treatment yet " + "\n");
				
				System.out.println("-----------------------------------------------------------------------" + "\n");
				
			} else if (ans1 == 'n' || ans1 == 'N') {
				System.out.println("End of Simulation" + "\n");
				System.exit(0);

			}
			if (HeWantYearReport == 0) { // if the user wants to see the yearly report
				System.out.println("Do you want to skip to the year report: Enter (1) if yes , (0) if no " + "\n");
				try {
					HeWantYearReport = scan.nextInt();
				} catch (Exception e2) {
					System.out.println("Sorry you entered wrong input, The program will skip this Quesion " + "\n");

				}
				if (HeWantYearReport != 1 && HeWantYearReport != 0) {
					while (true) {
						if (HeWantYearReport != 1 && HeWantYearReport != 0) {
							System.out.println("plese enter ether 1 or 0" + "\n");

							try {
								HeWantYearReport = scan.nextInt();
							} catch (Exception e2) {
								System.out.println(
										"Sorry you entered wrong input, the program will skip to year report: " + "\n");
								break;

							}
						} else
							break;
					}
				}

			}

		}

		double R_Tot = 0;
		double A_Tot = 0;
		for (int i = 0; i < archive.getCompleteArchiveOfGovernmentalTreatment().size(); i++) {  //calculating the average increase in time required for each treatment

			R_Tot = R_Tot + archive.getCompleteArchiveOfGovernmentalTreatment().get(i).getRequiredTime();
			A_Tot = A_Tot + archive.getCompleteArchiveOfGovernmentalTreatment().get(i).getActualTime();

		}

		double Increase_In_Time = ((A_Tot / R_Tot) * 100) - 100;

		System.out.println("We reach 360 days and this is the year report: " + "\n"); //printing the year report
		System.out.println("Total number of Governmental Treatments: "
				+ archive.getCompleteArchiveOfGovernmentalTreatment().size() + " Governmental Treatment" + "\n");
		System.out.println("The average increase in time required: " + Increase_In_Time + " %" + "\n");

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