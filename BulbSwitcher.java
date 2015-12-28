public class Solution {
    public int bulbSwitch(int n) {
        if (n < 0) return 0;

        // Alright so if we have n places, the ith place will be 1 if i has odd
        // number of factors.

        //  So now our problem reduces to finding numbers from 1 to n that have
        //  odd number of factors.

        // Now if lets analyze all numbers...

        // 1. Prime Numbers have 2 factors hence they are set to 0

        // 2. Now amongst non-prime numbers, any number that is not a square
        // will have factors occuring in pairs. For eg. 12 has factors
        // 1 x 12, 2 x 6, 3 x 4 -> Even number of factors, hence also set to 0.

        // 3. The only numbers that will have odd factors are squares. Their
        // square root will not have a pair and hence contributing to the odd
        // factors. For eg. 16: 1 x 16, 2 x 8, 4 x 4 -> 3 Factors, hence set to 1.

        // So now our problem reduces to finding the number of squares from 1 to
        // n, which is nothing but the Integral part of the square root of n

		return (int)Math.sqrt(n);
	}
}
