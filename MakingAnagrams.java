import java.util.Scanner;

public class MakingAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	
		StringBuilder str1= new StringBuilder(sc.next());
		StringBuilder str2= new StringBuilder(sc.next());
		for(int i=0;i<str1.length();i++) {
			for(int j=0;j<str2.length();j++) {
				if(str1.charAt(i)==str2.charAt(j)) {
					
					str1.deleteCharAt(i);
					str2.deleteCharAt(j);
					i=0;
					j=0;
				}
			}
		}
		
	
		System.out.println(str1.length()+str2.length());
		
		
	}

}
