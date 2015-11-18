public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height.length == 1 || height.length == 0) return 0;

        int left = 1, right = height.length, maxArea = 0;

        while(left < right) {
            //keep checking for max area
            int a = area(left, height[left-1], right, height[right-1]);

            if(a > maxArea) maxArea = a;

            if(height[left-1] < height[right-1]) left++;
            else right--;

        }

        return maxArea;
    }

    public int area(int x1, int y1, int x2, int y2) {
        return (int) Math.abs(x2 - x1) * Math.min(y1, y2);
    }
}
