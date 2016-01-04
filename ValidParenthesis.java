public class Solution {
    public boolean isValid(String s) {
    	Stack<Character> temp = new Stack<>();

    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if(c == '(' || c == '{' || c == '[') {
    			temp.push(c);
    		}
    		else {
    		    if (temp.isEmpty()) return false;
    			char d = temp.pop();
    			if(!map(c,d)) return false;
    		}
    	}
    	return (temp.isEmpty()) ? true : false;
    }

    public boolean map(char d, char c){
    	if(c == '(' && d == ')') return true;
    	if(c == '[' && d == ']') return true;
    	if(c == '{' && d == '}') return true;

    	return false;
    }
}
