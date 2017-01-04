package secondMidterm;

//Incomplete
public class TournamentTree {
	@SuppressWarnings("unused")
	private int[] tree, players;
	private static int s, lowExt, offset,n;
	
	public void start(int[] a){
		n = a.length;
		tree = new int[n];
		for(int i = 0; i <= n; i++){
			players[i] = a[i];
		}
		s = (int) Math.pow(2, Math.floor(Math.log10(n-1)/Math.log10(2)));
		offset = (2*s)-1;
		lowExt = 2*(n-s);
	}
	
	public int parent(int i){
		int p;
		if(i <= lowExt){
			p = (i+offset)/2;
		}
		else{
			p = (i-lowExt+n-1)/2;
		}
		return p;
	}
	
	public void play(){
		
	}
	
	public static void main(String[] args){
		int a = (int) Math.pow(2, Math.floor(Math.log10(8-1)/Math.log10(2)));
		System.out.println(a);
	}
}
