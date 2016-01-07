public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // binary search in first column to find which row the target could
        // possibly lie in.
        // then do a binary search in that row!! :) Simple.
        if(matrix.length == 0) return false;
    	if(matrix[0].length == 0) return false;
    	if (target < matrix[0][0]) return false;

    	int[] firstCol = new int[matrix.length];
    	for(int i = 0; i < matrix.length; i++) firstCol[i] = matrix[i][0];

    	int row = softbinarySearch(firstCol, target, 0, firstCol.length - 1);
    	return hardbinarySearch(matrix[row], target, 0, matrix[row].length - 1);
    }

    public int softbinarySearch(int[] arr, int target, int start, int end) {
    	if(start == end) return start;

    	int middle = (start + end) / 2;

        if (target < arr[middle]) return softbinarySearch(arr, target, start, middle - 1);
        else {
        	if (target < arr[middle + 1]) return middle;
        	else return softbinarySearch(arr, target, middle + 1, end);
        }

    }

    public boolean hardbinarySearch(int[] arr, int target, int start, int end) {
        if (start > end) return false;

    	int middle = (start + end) / 2;

        if(target == arr[middle]) return true;
        else if (target < arr[middle]) return hardbinarySearch(arr, target, start, middle - 1);
        else return hardbinarySearch(arr, target, middle + 1, end);
    }
}
