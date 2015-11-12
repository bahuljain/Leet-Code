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

    public void pushZerosToEnd(int arr[]) {
        int n = arr.length;
        int count = 0;  // Count of non-zero elements

        // Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
        for (int i = 0; i < n; i++)
            if (arr[i] != 0) arr[count++] = arr[i]; // here count is
                                       // incremented

        // Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
        // while (count < n) arr[count++] = 0;
        Arrays.fill(arr, count, n, 0);

        return arr;
    }
}
