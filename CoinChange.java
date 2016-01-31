public class Solution {
  public int coinChange(int[] coins, int amount) {    	
  	if (amount <= 0) return 0;
  	if (coins.length == 0)	return -1;
  	
  	int[] min = new int[amount + 1]; min[0] = 0;
  	
  	for(int i = 1; i <= amount; i++) {
  		
  		int m = Integer.MAX_VALUE;
  		
  		for(int j = coins.length - 1; j >= 0; j--) {
  			int coin = coins[j];
  			
  			if(i - coin < 0 || min[i - coin] == -1) {
  				continue;
  			} else {
  				m = Math.min(m, 1 + min[i-coin]);
  			}
  				
  		}
  		
  		min[i] = (m == Integer.MAX_VALUE) ? -1 : m;
  	}
  	
  	return min[amount];
  }
}
