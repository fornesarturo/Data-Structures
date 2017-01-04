package disjointSets;

public class DisjointSet {
	public static void main(String[] args){
		DisjointSet s = new DisjointSet();
		int n = 5;
		s.makeSet(n);
		System.out.println(s.numDisjointSets());
		s.union(0, 1);
		s.union(1, 2);
		s.union(3, 4);
		s.union(3, 2);
		System.out.println(s.numDisjointSets());
		System.out.print("Parents: ");
		for(int i =0; i < n;i++){
			System.out.print("["+s.p[i]+"]");
		}
		System.out.println();
		System.out.print("Size: ");
		for(int i =0; i < n;i++){
			System.out.print("["+s.size[i]+"]");
		}
		System.out.println();
		System.out.print("Rank: ");
		for(int i =0; i < n;i++){
			System.out.print("["+s.rank[i]+"]");
		}
	}
	int[] p;
	int[] rank;
	int[] size;
	int numSets;
	
	public void makeSet(int n){
		this.p = new int[n];
		this.rank = new int[n];
		this.size = new int[n];
		for(int i = 0; i < n; i++){
			this.p[i] = i;
			this.size[i] = 1;
			this.rank[i] = 0;
		}
		this.numSets = n;
	}
	
	public int findSet(int x){
		if(this.p[x] != x)
			this.p[x] = findSet(p[x]);
		return this.p[x];
	}
	
	public boolean isSameSet(int i, int j){
		i = findSet(i);
		j = findSet(j);
		return i==j;
	}
	
	public void union(int i, int j){
		i = findSet(i);
		j = findSet(j);
		
		if(this.rank[i] > this.rank[j]){
			this.p[j] = i;
			this.size[i] += this.size[j];
		}
		else{
			this.p[i] = this.p[j];
			this.size[this.p[j]] += this.size[i];
		}
		if(this.rank[i] == this.rank[j])
			this.rank[j] = this.rank[j] +1;
		this.numSets--;
	}
	
	public int numDisjointSets(){
		return this.numSets;
	}
	
	public int sizeOfSet(int i){
		return this.size[i];
	}
}
