
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
class Heap{
	
	Queue<Integer> lowerhalf = new PriorityQueue<>(Comparator.reverseOrder());
	Queue<Integer> upperhalf = new PriorityQueue<>();
	public void add(int number) {
		Queue<Integer> target = lowerhalf.size() <= upperhalf.size() ? lowerhalf:upperhalf;
		target.add(number);
		balance();
	}
	public void balance() {
		while(!lowerhalf.isEmpty() && !upperhalf.isEmpty() && lowerhalf.peek() > upperhalf.peek()){
			Integer lowerhead = lowerhalf.poll();
			Integer upperhead = upperhalf.poll();
			lowerhalf.add(upperhead);
			upperhalf.add(lowerhead);
		}
	}
	public double median() {
		if(lowerhalf.isEmpty() && upperhalf.isEmpty()) {
			return 0.00;
		}
		else {
			return lowerhalf.size()== upperhalf.size() ? (lowerhalf.peek()+upperhalf.peek())/2.0 : lowerhalf.peek();
		}
		
	}
}
public class RunningMedian {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Heap heap = new Heap();
		
		for (int i=0;i<n;i++) {
			heap.add(sc.nextInt());
			System.out.println(heap.median());
		}
			sc.close();	
	}

}
