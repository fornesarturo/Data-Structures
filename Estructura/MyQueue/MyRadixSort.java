package MyQueue;

public class MyRadixSort {
	public static ChainLinearList<Integer> RadixSort(ChainLinearList<Integer> a, int k){
		int radix = 10;
		int power = 1;
		int digit,index;
		MyScratchQueue<Integer>[] digitQueue = new MyScratchQueue[10];
		MyScratchQueue<Integer>[] indexQueue = new MyScratchQueue[10];
		ChainLinearList<Integer> b = new ChainLinearList<Integer>();
		for(int i = 0; i < a.size(); i++){
			b.add(i, i);
		}
		for(int i = 0; i < 10; i++){
			digitQueue[i] = new MyScratchQueue<Integer>();
			indexQueue[i] = new MyScratchQueue<Integer>();
		}
		
		for(int i = 0; i < k; i++){
			
			int size = a.size();
			for(int j = 0; j < size; j++){
				digit = a.remove(0);
				index = b.remove(0);
				digitQueue[(digit/power)%10].enqueue(digit);
				indexQueue[(digit/power)%10].enqueue(index);
			}
			for(int j = 0; j < radix; j++){
				while(!digitQueue[j].empty()){
					a.add(a.size(), digitQueue[j].dequeue());
					b.add(b.size(), indexQueue[j].dequeue());
				}
			}
			power *= 10;
		}
		return b;
		
	}
	public static void main(String[] args){
		ChainLinearList<Integer> chain = new ChainLinearList<Integer>();
		
		chain.add(0, 1927566205);
		chain.add(1, 1626586037);
		chain.add(2, 1693158739);
		chain.add(3, 1178925721);
		chain.add(4, 1248912354);
		chain.add(5, 1010385034);
		
		ChainLinearList<Integer> indexes = RadixSort(chain,10);
		System.out.println(indexes.output());
	}
}
