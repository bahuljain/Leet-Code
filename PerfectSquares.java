public class PerfectSquares {

    // solved this using dynamic programming :) got a really good running time
    public int numSquares(int n) {

        int[] steps = new int[n+1];

        for(int i = 1; i <= n; i++){

            double root = Math.sqrt(i);

            if(root - (int)root == 0)
                steps[i]=1;
            else {
                int min = Integer.MAX_VALUE;
                int r = (int)root;
                while(r >= 1) {
                    if(min > 1 + steps[i-r*r])
                        min = 1 + steps[i-r*r];
                    r--;
                }
                steps[i] = min;
            }
        }

        return steps[n];

    }
}
