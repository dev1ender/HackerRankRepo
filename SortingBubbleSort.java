import java.util.Arrays;
import java.util.Scanner;

public class SortingBubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count=0;
		int[] a= new int[n];
		for (int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
//		int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(token->Integer.parseInt(token)).toArray();
		for (int i = 0; i < n; i++) {
		    
		    for (int j = 0; j < n - 1; j++) {
		        // Swap adjacent elements if they are in decreasing order
		        if (a[j] > a[j + 1]) {
		            int temp = a[j];
		            a[j] = a[j+1];
		            a[j+1] = temp;
		            count++;
		        }
		    }
		    
		}

		System.out.println("Array is sorted in "+count +" swaps.");
		System.out.println("First Element: "+a[0]);
		System.out.println("Last Element: "+a[n-1]);
		sc.close();
	}

	

}
