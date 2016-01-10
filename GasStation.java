public class Solution {
    // a circuit cannot be completed if sum of all gas - sum of all cost is < 0

    // now as we move in the array, if at any point we encounter that sum is
    // becoming negative that means the chosen start point is wrong and it has
    // to be after the current gas station cause that is where all the problem
    // happens. Therefore we reset s, and again repeat the process!!
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if (n == 0) return -1;

        // this variable simple is to compute sum of all (gas[i] - cost[i])
        int sum = 0;

        // s tracks sum of all gas[i]-cost[i] from the new 'start' point.. If
        // this value becomes negative, then start point has to be ahead of the
        // current gas station
        int s = 0;
        int start = 0;

        for(int i = 0; i < n; i++) {
            int cur = gas[i] - cost[i];
            sum += cur;

            s+= cur;
            if(s < 0) {
                s = 0;
                start = i+1;
            }

        }

        return (sum < 0) ? return -1 : start;
    }
}
