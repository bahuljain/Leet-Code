public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap h = new HashMap(nums.length);
        for(int i = 0; i < nums.length; i++) {
            h.put(new Integer(nums[i]), 0);
        }

        for(int i = 0; i < nums.length; i++) {
            h.put(new Integer(nums[i]), (int)h.get(new Integer(nums[i])) + 1);
        }

        for(int i = 0; i < nums.length; i++) {
            if((int)h.get(new Integer(nums[i])) > nums.length/2) {
                return nums[i];
            }
        }
        return -1;

    }
}
