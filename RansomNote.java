
import java.util.*;
import java.util.Scanner;

public class RansomNote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		        Scanner sc = new Scanner(System.in);
		        int n = sc.nextInt();
		        int l = sc.nextInt();
//		        int[] arr= new int[n];
		        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(token -> Integer.parseInt(token)).toArray();
//		        for(int i=0;i<n;i++) {
//		        	arr[i]=sc.nextInt();
//		        }
		        
		        while(l>0){
		            l--;
		            int lower = sc.nextInt();
		            int upper = sc.nextInt();
		            int sum =0;
		            for (int i = lower-1;i<upper;i++){
		                sum=sum+arr[i];
		            }
		            
		            int div = upper-lower+1;
		            System.out.println(sum/div);
		        }

		    
			
	}

}
