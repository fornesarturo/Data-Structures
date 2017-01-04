package winnerTree;

public class MinWinnerMain {
	public static void main(String[] args){
		MinWinner<Integer> tree = new MinWinner<Integer>();
		Integer[] a = {0,3,1,2,5,8,6};
		tree.initialize(a);
		System.out.println(tree.toString());
		System.out.println(tree.getWinner());
		Integer[] b = new Integer[a.length];
		for(int i = 1; i < a.length; i++){
			b[i] = tree.getWinner();
			System.out.println("Winner: "+tree.getWinner());
			System.out.println("Competitor: "+tree.findCompetitor(tree.getWinnerIndex()));
			tree.change(tree.getWinnerIndex(),0x7FFFFFFF); //
			tree.replay(tree.getWinnerIndex());
		}
		for(int i = 1; i < b.length; i++){
			System.out.print("["+b[i]+"]");
		}
	}
}