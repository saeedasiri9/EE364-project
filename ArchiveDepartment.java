package departments_employees;

import java.util.*;

public class ArchiveDepartment {
	private int Index = 0;
	private ArrayList<String> IDArchiveOfGovernmentalTreatment = new ArrayList<>();
	private ArrayList<String> IndexArchiveOfGovernmentalTreatment = new ArrayList<>();
	private ArrayList<governmentalTreatment> CompleteArchiveOfGovernmentalTreatment = new ArrayList<>();

	private ArrayList<governmentalTreatment> ArchiveOfGovernmentalTreatment = new ArrayList<>();

	public ArchiveDepartment() {
		// TODO Auto-generated constructor stub
	}

	public void ArchMethod(governmentalTreatment o) { 

		o.setErrorPercent(o.getErrorPercent() - 10); //the error percent will decrease by 10% every time the method is used

		if (o.getErrorPercent() < 0) { //if the error percent became negative the method will set it to zero
			o.setErrorPercent(0);
		}

	}

	public void PrintArch(governmentalTreatment o) {
		setIndex(getIndex() + 1);

		String ID = String.valueOf(o.getID());    //line 30 and 31 take the ID and Index of the treatment and turn them into strings
		String Index = String.valueOf(getIndex());
		getIDArchiveOfGovernmentalTreatment().add(ID);        //line 32 and 33 add those string into these array lists
		getIndexArchiveOfGovernmentalTreatment().add(Index);

	}

	public ArrayList<governmentalTreatment> getArchiveOfGovernmentalTreatment() {
		return ArchiveOfGovernmentalTreatment;
	}

	public ArrayList<String> getIDArchiveOfGovernmentalTreatment() {
		return IDArchiveOfGovernmentalTreatment;
	}

	public void setIDArchiveOfGovernmentalTreatment(ArrayList<String> completeArchiveOfGovernmentalTreatment) {
		IDArchiveOfGovernmentalTreatment = completeArchiveOfGovernmentalTreatment;
	}

	public ArrayList<String> getIndexArchiveOfGovernmentalTreatment() {
		return IndexArchiveOfGovernmentalTreatment;
	}

	public void setIndexArchiveOfGovernmentalTreatment(ArrayList<String> indexArchiveOfGovernmentalTreatment) {
		IndexArchiveOfGovernmentalTreatment = indexArchiveOfGovernmentalTreatment;
	}

	public void setArchiveOfGovernmentalTreatment(ArrayList<governmentalTreatment> archiveOfGovernmentalTreatment) {
		ArchiveOfGovernmentalTreatment = archiveOfGovernmentalTreatment;
	}

	public int getIndex() {
		return Index;
	}

	public void setIndex(int index) {
		Index = index;
	}

	public ArrayList<governmentalTreatment> getCompleteArchiveOfGovernmentalTreatment() {
		return CompleteArchiveOfGovernmentalTreatment;
	}

	public void setCompleteArchiveOfGovernmentalTreatment(
			ArrayList<governmentalTreatment> completeArchiveOfGovernmentalTreatment) {
		CompleteArchiveOfGovernmentalTreatment = completeArchiveOfGovernmentalTreatment;
	}

}