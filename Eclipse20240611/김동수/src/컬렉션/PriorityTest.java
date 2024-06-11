package 컬렉션;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Cat> catPriorityQueue = new PriorityQueue<Cat>(3);
		catPriorityQueue.add(new Cat(5));
		catPriorityQueue.add(new Cat(3));
		catPriorityQueue.add(new Cat(7));
		
		System.out.println("크기순");
		
		for(int i = 0; i < 3; i++) {
			Cat in = catPriorityQueue.poll();
			System.out.println("Proccessing Cat : "+ in);
		}
		
		final Comparator<Cat> idComparator = new Comparator<Cat>() {
			public int compare(Cat c1, Cat c2) {
				return c2.size-c1.size;
			}
		};
		Queue<Cat> catPriorityQueue2 = new PriorityQueue<Cat>(3, idComparator);
		catPriorityQueue2.add(new Cat(5));
		catPriorityQueue2.add(new Cat(3));
		catPriorityQueue2.add(new Cat(7));
		System.out.println();
		System.out.println("크기 역순");
		
		for(int i = 0 ; i < 3; i++)
		{
			Cat in = catPriorityQueue2.poll();
			System.out.println("Processing Cat : "+ in);
		}
	}

}
