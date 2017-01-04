
public class MainPeak {
	public static void main(String[] args){
		Peak k = new Peak();
		
		int[] h = {1,2,3,4,10,9,9,8,8,7,7,6,5,3,2,1,0};
		int[] j = {0,6,5,4,3};
		
		System.out.println(k.OneDRecursive(h));
		System.out.println(k.OneDRecursive(j));
		
		int[][] b = {
				{0,1,3,1,0},
				{1,2,4,2,1},
				{2,3,3,3,2},
				{6,2,1,7,12},
				{0,0,0,1,3}};
		System.out.println(k.TwoDRecursive(b));
	}
}
