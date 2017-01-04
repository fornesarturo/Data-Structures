package winnerTree;

public interface TournamentTree<E extends Comparable<E>> {
	E getWinner();
	void initialize(E[] a);
	void play(int father, int left, int right);
	void replay(int i);
	String toString();
}
