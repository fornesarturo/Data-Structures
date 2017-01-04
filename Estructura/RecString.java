public class RecString {
	
	public static int StrLen (String string){
		if(string.equals(""))
			return 0;
		else
			return StrLen(string.substring(1))+1;
	}

	public static void main(String[] args) {
		//System.out.println(StrLen("four"));
		String s = "hey";
		String m = "yeh";
		
		System.out.println(s.substring(s.length()-1, s.length()));
		System.out.println(s.substring(0, s.length()-1));
		
		System.out.println(m.substring(0,1));
		System.out.println(m.substring(1));
		
		
	}
}