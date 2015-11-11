public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    public int search(int[] nums, int target, int start, int end) {
        if (start == end) {
            if(nums[end] == target) return end;
            else if (nums[end] > target) return end;
            else return end + 1;
        } else if (start > end) {
            return end+1;
        } else {
            int mid = (end-start)/2 + start;

            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) return search(nums, target, start, mid-1);
            else return search(nums, target, mid+1, end);
        }
    }
}
