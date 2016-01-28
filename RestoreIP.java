public class Solution {
  public List<String> restoreIpAddresses(String s) {
  	List<String> ips = new ArrayList<>();
  	    	
  	if (s.length() > 12 || s.length() < 4) return ips;
  	
  	StringBuilder sb = new StringBuilder();
  	addDots(ips, 3, sb, s, 0);
  	return ips;
  }
  
  private void addDots(List<String> ips, int dots, StringBuilder sb, String s, int start) {
  	if (dots == 0 && start < s.length()) {
  		int num = 0;
  		if (s.charAt(start) == '0' && start != s.length() - 1) return;
  		
  		for (int i = start; i < s.length(); i++) {
  			num = num*10 + (s.charAt(i) - 48);    			
  		}
  		
  		if (num <= 255) {
  			sb.append(num);
  			ips.add(sb.toString());
  		}
  	} else {
  		if (start < s.length()) {
  			int num = 0;
  			for (int i = start; i < s.length(); i++) {
  				int t = 0;
  				num = num * 10 + (s.charAt(i) - 48);
  				if (t == num) {
  					StringBuilder temp = new StringBuilder(sb.toString());
  					temp.append(0); temp.append('.');
  					addDots(ips, dots - 1, temp, s, i+1);
  					return;
  				}
  				
  				
  				if (num <= 255) {
  					StringBuilder temp = new StringBuilder(sb.toString());
  					temp.append(num); temp.append('.');
  					addDots(ips, dots - 1, temp, s, i+1);
  				} else {
  					return;
  				}
  			}
  		}
  	}
  }
}
