public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);

        // premultiply
        for(int i = 1; i < nums.length; i++) output[i] =  output[i-1] * nums[i-1];

        // post multiply and combine
        int post = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            post *= nums[i+1];
            output[i] *= post;
        }

        return output;
    }
}
