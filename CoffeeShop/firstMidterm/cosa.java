package firstMidterm;

import java.util.concurrent.LinkedBlockingQueue;

public class cosa {
	public static void main(String[] args) {
	    LinkedBlockingQueue<Integer> asd = new LinkedBlockingQueue<Integer>();
	    asd.add(1);
	    asd.add(2);
	    asd.add(3);
	    asd.add(4);
	    asd.add(5);
	    asd.add(6);
	    asd.add(7);
	    asd.add(8);
	    asd.add(9);
	    asd.add(10);
	    System.out.println(asd.toString());
	    
	    LinkedBlockingQueue<Integer> mitadAsd = new LinkedBlockingQueue<Integer>();
	    
	    System.out.println(asd.size());
	    
	    for (int i=asd.size()/2; i > 0; i--) {
	      mitadAsd.add(asd.poll());
	    }
	    System.out.println(mitadAsd.toString());
	    
	    LinkedBlockingQueue<Integer> nuevaAsd = new LinkedBlockingQueue<Integer>();
	    
	    while (asd.size() != 0) {
	      if (mitadAsd.peek() != null){
	    	  nuevaAsd.add(mitadAsd.poll());  
	      }  
	      nuevaAsd.add(asd.poll());
	    }
	    System.out.println(nuevaAsd.toString());
  }
}