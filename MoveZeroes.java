public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i=0,j=0;
        boolean flag=true;
        while(i<nums.length && j<nums.length){
            //finds the first available non zero number that can be swapped
            while(i<nums.length){
                if(nums[i]!=0)
                    break;
                i++;
            }

            //finds the first available zero that can be swapped
            while(j<nums.length){
                if(nums[j]==0)
                    break;
                j++;
            }

            if(i==nums.length || j==nums.length)
                break;

            if(i<j){
                i++;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }

        }
    }
}
