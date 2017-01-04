package Patients;

public class PatientRecord {
	public String name;
	public String date;
	public String reasonOfVisit;
	public String treatment;
	
	public PatientRecord(String name,String date, String reason, String treatment){
		this.name = name;
		this.date = date;
		this.reasonOfVisit = reason;
		this.treatment = treatment;
	}
	public String toString(){
		return "Name: "+this.name+" Date: "+this.date+" Reason Of Visit: "+this.reasonOfVisit+" Treatment: "+this.treatment;
	}
}