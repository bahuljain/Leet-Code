/*Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/


//Brute Force Solution
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length==0){
            System.out.println("Empty Array - Target not found");
            return null;
        }else{
            for(int i=0;i<nums.length-1;i++){
                for(int j=i+1;j<nums.length;j++){
                    if(nums[i]+nums[j]==target){
                        int[] A = {i+1,j+1};
                        return A;
                    }
                }
            }
            return null;
        }
    }
}

//Using HashMap
public int[] twoSums(int[] nums, int target) {
        if(nums.length==0) {
            System.out.println("Empty Array - Target not found");
            return null;
        } else {
            HashMap h = new HashMap(256);
            for(int i=0;i<nums.length;i++) {
                if(h.contains(new Integer(target - nums[i]))) {
                    int[] A = {(Integer)h.get(new Integer(target - nums[i])),i+1};
                    return A;
                } else {
                    h.put(new Integer(nums[i]), new Integer(i+1));
                }
            }
            return null;
        }
    }