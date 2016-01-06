public class Solution {
    // FLow -> number = nums[i]
    // 1st time: Two doesn't get the number cause both one and two didn't have it before
    //           One gets the numbers
    //           Three doesn't get it cause two doesnt have it, hence nothing changes
    //
    // 2st time: Two gets it cause one had it before
    //           One loses the number
    //           Three doesn't get it cause one doesnt have it, hence nothing changes
    //
    // 3rd time: Two still retains the number because it is ORing with itself and one
    //           One gets the number again
    //           Three gets it cause both one and two have it now,
    //           and now the number is cleared from both one and two
    //
    public int singleNumber(int[] nums) {
        int one = 0; int two = 0; int three = 0;
        for(int i = 0; i < nums.length; i++){
            // if now one is nums[i], by ANDing and ORing, two now equals to nums[i]
            two |= one & nums[i];

            // if now one is zero, it stores the nums[i] in it
            // if now one is nums[i], it clears the content since a^a = 0
            // if now one is other number, it just accumulates
            one ^= nums[i];

            // if now one and two has the same value, it means the
            // number shows 3 times, thus
            three = one & two;

            // if three is the number, clear this number from the one and two
            // a &= ~b => a - b
            // 0100 | 0011 = 3+4 = 7  (0111)
            // 7 &= ~3 => 0111 & 1100 = 0100 = 4 (7 - 3)
            one &= ~three;
            two &= ~three;
        }
        return one;
    }

}
