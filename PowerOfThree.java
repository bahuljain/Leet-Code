public class Solution {
    public boolean isPowerOfThree(int n) {
        double log = Math.log(n)/Math.log(3);
        if (log % 1 > 0.9999999999999 || log % 1 < 0.00000000000001)
            return true;
        else
            return false;
    }
}
