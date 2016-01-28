public class Solution {
  public int trap(int[] height) {
    int len = height.length;
    if (len < 3 ) return 0;
    
    int l = height[0];
    
    int[] left = new int[len];
    left[0] = 0;
    
    for (int i = 1; i < len-1; i++) {
      if (height[i] >= height[i-1]) { 
        left[i] = left[i-1]; 
        l = Math.max(l, height[i]); 
      } else { 
        left[i] = l; 
      }
    }
    
    l = height[len - 1];
    int total = 0;
    int[] right = new int[len];
    right[len-1] = 0;
    
    for (int i = len - 2; i > 0; i--) {
      if (height[i] >= height[i+1]) { 
        right[i] = right[i+1];
        l = Math.max(l, height[i]); 
      } else {
        right[i] = l;
      }
      
      int cur = Math.min(left[i], right[i]) - height[i];
      total += (cur > 0) ? cur : 0;
      
    }
    return total;
  }
}
