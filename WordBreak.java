public class Solution {
	boolean[] visited;
	
  public boolean wordBreak (String s, Set<String> wordDict) {
    if (s.length() == 0) return false;
    
    visited = new boolean[s.length()];
    
    return check(0, s, wordDict);
  }
  
  private boolean check (int start, String s, Set<String> wordDict) {
  	if (!visited[start]) {
  		if (wordDict.contains(s)) return true;
  		for (int i = 1; i < s.length(); i++) {
        if(wordDict.contains(s.substring(0,i))) {
        	String right = s.substring(i);
        	if (check(i, right, wordDict)) return true;
        }
        
      }
      visited[start] = true;
  	}    	
  	return false;
  }
}
