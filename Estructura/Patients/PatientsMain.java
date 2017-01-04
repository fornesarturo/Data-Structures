package Patients;

public class PatientsMain {
	public static void main(String[] args){
		PatientDataBase p = new PatientDataBase();
		PatientRecord a = new PatientRecord("Arturo","10-20-16","Coughing","Syrup");
		PatientRecord b = new PatientRecord("Arturo","11-20-16","Diarrhea","Tablet");
		PatientRecord c = new PatientRecord("Casiel","12-24-17","Sneezes","Placebo");
		p.addRecord(a);
		p.addRecord(b);
		p.addRecord(c);
		System.out.println(p.reasonForVisit(b.name, a.date));
		System.out.println(p.visits("Arturo").output());
		System.out.println(p.visits("Casiel").output());
		System.out.println(p.treatment("Casiel", "10-20-14"));
		System.out.println(p.treatment("Casiel", "12-24-17"));
		System.out.println(p.remove("Casiel", "12-24-17").toString());
		System.out.println(p.treatment("Casiel", "12-24-17"));
	}
}
