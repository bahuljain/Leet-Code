public class ClimbStairs {
    public int climbStairs(int n) {
        int[] counts = new int[n+1];

        for (int i = 0; i <= n; i++){
            if(i == 1 || i == 0) {
                counts[i] = 1;
            } else {
                counts[i] = counts[i-1] + counts[i-2];
            }
        }
        return counts[n];
    }
}
