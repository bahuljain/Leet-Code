public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;

        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] == 9) {
                carry = 1;
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }

        int[] numbers = new int[digits.length + 1];
        numbers[0] = 1;
        return numbers;
    }
}
