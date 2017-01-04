package winnerTree;

public class MinWinner<E extends Comparable<E>> implements TournamentTree<E> {
	private E[] players;
	private int[] tree;
	private int offset;
	private int lowExt;
	
	public E getWinner() {
		return (tree != null)?players[tree[1]]:null;
	}
	
	public int getWinnerIndex(){
		return (tree != null)?tree[1]:null;
	}

	public void initialize(E[] a){
		int n = a.length-1;
		if(n < 2)
			throw new IllegalArgumentException();
		this.players = a;
		this.tree = new int[n];
		int i,s;
		for(s = 1; s*2 <= n-1; s+=s);
		this.lowExt = 2*(n-s);
		this.offset = 2*s-1;
		//Do the matches for the lowest level of the tree.
		for(i = 2; i <= this.lowExt;i+=2)
			play((i+this.offset)/2,i-1,i);
		//When the number of players is odd.
		if(n%2==1){
            play(n/2,this.tree[n-1],this.lowExt+1);
            i = this.lowExt+3;
		}
		//When the number of players is even.
		else
            i = this.lowExt+2;
		//Play the remaining matches.
        for(;i<=n;i+=2)
            play((i-this.lowExt+n-1)/2, i-1,i);
	}

	public void play(int father, int left, int right) {
		tree[father] = (players[left].compareTo(players[right])<0)?left:right;
		while(father%2 == 1 && father > 1){
			tree[father/2] = (players[tree[father-1]].compareTo(players[tree[father]])<0)?tree[father-1]:tree[father];
			father/=2;
		}
	}

	public void replay(int thePlayer) {
		int n = this.players.length-1;
		if(thePlayer <= 0 || thePlayer > n)
			throw new IndexOutOfBoundsException(thePlayer+" invalid player");
		int matchNode, leftChild, rightChild;
		//Power of two.
		if(thePlayer <= this.lowExt){
			matchNode = (this.offset+thePlayer)/2;
			leftChild = 2*matchNode-this.offset;
			rightChild = leftChild+1;
		}
		//Not a power of two.
		else{
			matchNode = (thePlayer-this.lowExt+n-1)/2;
			//Odd, last node on the tree.
			if(2*matchNode == n-1){
				leftChild = tree[2*matchNode];
				rightChild = thePlayer;
			}
			//Even.
			else{
				leftChild = 2*matchNode-n+1+this.lowExt;
				rightChild = leftChild + 1;
			}
		}
		//First match done.
		tree[matchNode] = (players[leftChild].compareTo(players[rightChild]) < 0)?leftChild:rightChild;
		//If the match is to be taken place in the last position of the tree.
		if(matchNode == n-1 && n%2 ==1){
			matchNode/=2;
			tree[matchNode] = players[tree[n-1]].compareTo(players[lowExt+1])<0?tree[n-1]:lowExt+1;
		}
		matchNode/=2;
		//Do the remaining matches moving from match node to match node.
		for(; matchNode >= 1; matchNode/=2)
			tree[matchNode] = players[tree[2*matchNode]].compareTo(players[tree[2*matchNode+1]])<0?tree[2*matchNode]:tree[2*matchNode+1];
	}
	
	public void change(int thePlayer,E value){
		this.players[thePlayer] = value;
	}
	
	public E findCompetitor(int thePlayer){
		int n = this.players.length-1;
		int matchNode, leftChild, rightChild;
		//Power of two.
		if(thePlayer <= this.lowExt){
			matchNode = (this.offset+thePlayer)/2;
			leftChild = 2*matchNode-this.offset;
			rightChild = leftChild+1;
		}
		//Not a power of two.
		else{
			matchNode = (thePlayer-this.lowExt+n-1)/2;
			//Odd, last node on the tree.
			if(2*matchNode == n-1){
				leftChild = tree[2*matchNode];
				rightChild = thePlayer;
			}
			//Even.
			else{
				leftChild = 2*matchNode-n+1+this.lowExt;
				rightChild = leftChild + 1;
			}
		}
		return thePlayer==leftChild?players[rightChild]:players[leftChild];
	}
	
	public String toString(){
		String output = "";
		output += ("Offset: "+this.offset+"\t LowExt: "+this.lowExt+"\n");
		int n = this.tree.length;
		for(int i = 1; i < n; i++)
			output += ("["+this.players[this.tree[i]]+"]");
		return output;
	}
	
}
