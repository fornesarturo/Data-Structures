package firstMidterm;

public class ThreeWaySplitting {
	public static Chain<Integer> a = new Chain<Integer>();
	public static Chain<Integer> b = new Chain<Integer>();
	public static Chain<Integer> c = new Chain<Integer>();
	public static Chain<Integer> d = new Chain<Integer>();
	
	//O(n)
	public static void ThreeWaySplit(Chain<Integer> a, Chain<Integer> b,
			Chain<Integer> c, Chain<Integer> d){
		
		Chain<Integer>.IteratorThing it = a.new IteratorThing();
		int i = 0;
		
		b.makeEmpty();
		c.makeEmpty();
		d.makeEmpty();
		
		while(it.hasNext()){
			if(i%3 == 0){
				b.append(it.next());
			}
			else if(i%3 == 1){
				c.append(it.next());
			}
			else if(i%3 == 2){
				d.append(it.next());
			}
			i++;
		}
	}
	
	public static void main(String[] args){
		a.append(1);
		a.append(2);
		a.append(3);
		a.append(4);
		a.append(5);
		a.append(6);
		
		System.out.println(a.output());
		
		
		b.append(2);
		
		c.append(3);
		
		d.append(4);
		
		
		System.out.println(b.output());
		System.out.println(c.output());
		System.out.println(d.output());
		
		ThreeWaySplit(a,b,c,d);
		
		System.out.println(b.output());
		System.out.println(c.output());
		System.out.println(d.output());
	}
}
