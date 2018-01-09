import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TrieNode{
	char c;
	boolean wordterm;
	int countwords;
	HashMap<Character,TrieNode> childern = new HashMap<Character,TrieNode>();
	public TrieNode() {}
	
	public TrieNode(char c) {
		this.c=c;
		countwords=0;
	}
}
 class Trie{
	private TrieNode root;
	 public Trie() {
		 root = new TrieNode();
	 }
	 
	 public void insert(String word) {
		 HashMap<Character,TrieNode> childern = root.childern;
		 
		 for(int i=0;i<word.length();i++) {
			 char c = word.charAt(i);
			 TrieNode t;
			 if(childern.containsKey(c)) {
				 t = childern.get(c);
			 }else {
				 t = new TrieNode(c);
				 childern.put(c,t);
				 
			 }
			 t.countwords++;
			 childern = t.childern;
			 
			 if(i==word.length()-1) {
				 t.wordterm =true;
			 }
		 }
	 }
	 
	public boolean  search(String word) {
		 TrieNode t = searchNode(word);
		 if(t!=null && t.wordterm) {
			 return true;
		 }
		 else
			 return false;
	 }
	public int startsWith(String prefix) {
	      TrieNode t = searchNode(prefix);
	      if(t == null) {
	    	  return 0;
	      }
	      return t.countwords;
		
	    }
	private TrieNode searchNode(String str) {
		Map<Character,TrieNode> childern = root.childern;
		TrieNode t = null;
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(childern.containsKey(c)) {
				t=childern.get(c);
				childern= t.childern;
			}
			else
				return null;
			
		}
		return t; 
	}
	 
}
public class ImplementTries {
	
	public static void main(String[] args) {
		
	Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      Trie trie = new Trie();
      for (int i = 0; i < n; i++) {
          String operation = scan.next();
          String contact   = scan.next();
          if (operation.equals("add")) {
              trie.insert(contact);
          } else if (operation.equals("find")) {
              System.out.println(trie.startsWith(contact));
          }
      }
      scan.close();
	}

}


//import java.util.Scanner;
//import java.util.HashMap;
//
//public class Solution {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        Trie trie = new Trie();
//        for (int i = 0; i < n; i++) {
//            String operation = scan.next();
//            String contact   = scan.next();
//            if (operation.equals("add")) {
//                trie.add(contact);
//            } else if (operation.equals("find")) {
//                System.out.println(trie.find(contact));
//            }
//        }
//        scan.close();
//    }
//}
//
///* Based loosely on tutorial video in this problem */
//class TrieNode {
//    private HashMap<Character, TrieNode> children = new HashMap<>();
//    public int size;
//
//    public void putChildIfAbsent(char ch) {
//        children.putIfAbsent(ch, new TrieNode());
//    }
//
//    public TrieNode getChild(char ch) {
//        return children.get(ch);
//    }
//}
//
//class Trie {
//    TrieNode root = new TrieNode();
//
//    Trie(){} // default constructor
//    
//    Trie(String[] words) {
//        for (String word : words) {
//            add(word);
//        }
//    }
//    
//    public void add(String str) {
//        TrieNode curr = root;
//        for (int i = 0; i < str.length(); i++) {
//            Character ch = str.charAt(i);
//            curr.putChildIfAbsent(ch);
//            curr = curr.getChild(ch);
//            curr.size++;
//        }
//    }
//    
//    public int find(String prefix) {
//        TrieNode curr = root;
//        
//        /* Traverse down tree to end of our prefix */
//        for (int i = 0; i < prefix.length(); i++) {
//            Character ch = prefix.charAt(i);
//            curr = curr.getChild(ch);
//            if (curr == null) {
//                return 0;
//            }
//        }
//        return curr.size;
//    }
//}
