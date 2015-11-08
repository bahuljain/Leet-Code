public class SingleNumber {

    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];

        int s = nums[0];

        for(int i = 1; i < nums.length; i++) {
            s ^= nums[i];
        }

        return s;
    }

    // a dirtier alternative would be to create a hashmap and keep track of
    // count of every element. And return the element that has count = 1.
}
