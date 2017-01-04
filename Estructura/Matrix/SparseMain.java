package Matrix;

public class SparseMain {
	public static void main(String[] args) {
		SparseMatrix<Integer> sparse = new SparseMatrix<Integer>(
				new Integer[][]{
			{1,0,0,0,0,0,0,2,1},
			{0,0,0,0,0,0,1,0,0},
			{0,0,0,1,1,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,1,1,0,0,0},
			{0,0,0,1,1,1,8,0,0},
			{9,0,1,1,1,1,1,0,9}
			});
		
		for(int j=1;j<8;j++){
			for(int i=1;i<10;i++){
				sparse.add(j, i,9);
			}
		}
		
		for(int j=1;j<8;j++){
			for(int i=1;i<10;i++){
				System.out.print(sparse.get(j, i));
			}
			System.out.println();
		}
		
		for(int j=1;j<8;j++){
			for(int i=1;i<10;i++){
				System.out.print(sparse.remove(j, i));
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println(sparse.output());
	}
}
