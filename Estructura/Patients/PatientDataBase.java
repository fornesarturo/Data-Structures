package Patients;

public class PatientDataBase extends MyHashTable<String,PatientRecord>{
	
	public PatientDataBase(){
		super();
	}
	
	private void add(String key, PatientRecord record,String date){
		if(this.size >= this.m-1 || (this.size+0.0)/(this.m) >= DEFAULT_CHARGE)
			this.rehash();
		int h = this.hash(key);
		for(Node<String,PatientRecord> n = this.table[h]; n != null; n = n.next){
			if(n.key.equals(key) && n.value.date.equals(date)){
				n.value = record;
				return;
			}
		}
		Node<String,PatientRecord> added = new Node<String,PatientRecord>(key,record,this.table[h]);
		this.table[h] = added;
		this.size++;
	}
	
	private PatientRecord getValue(String key, String date){
		int h = this.hash(key);
		for(Node<String,PatientRecord> n = this.table[h]; n != null; n = n.next){
			if(n.key.equals(key) && n.value.date.equals(date)){
				return n.value;
			}
		}
		return null;
	}
	
	public void addRecord(PatientRecord record){
		String key = record.name;
		String date = record.date;
		this.add(key, record,date);
	}
	
	public String reasonForVisit(String name, String date){
		PatientRecord record = this.getValue(name,date);
		if(record==null){
			return null;
		}
		return record.reasonOfVisit;
	}
	
	public String treatment(String name, String date){
		PatientRecord record = this.getValue(name,date);
		if(record==null){
			return null;
		}
		return record.treatment;
	}
	
	public ArrayLinearList<String> visits(String name){
		int h = this.hash(name);
		ArrayLinearList<String> output = new ArrayLinearList<String>();
		for(Node<String,PatientRecord> n = this.table[h]; n != null; n = n.next){
			if(n.key.equals(name)){
				output.add(output.size(),n.value.date);
			}
		}
		return output;
	}
	public PatientRecord remove(String k,String date) {
		int h = this.hash(k);
		Node<String,PatientRecord> first = this.table[h];
		if(first.key.equals(k) && first.value.date.equals(date)){
			PatientRecord saved = first.value;
			this.table[h] = first.next;
			this.size--;
			return saved;
		}
		for(Node<String,PatientRecord> n = first; n.next != null; n=n.next){
			if(n.next.key.equals(k) && n.next.value.date.equals(date)){
				PatientRecord chosenOne = n.next.value;
				n.next = n.next.next;
				this.size--;
				return chosenOne;
			}
		}
		return null;
	}
}
