public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] == 9) {
                carry = 1;
                digits[i] = 0;
            } else {
                digits[i] += 1;
                carry = 0;
                break;
            }
        }
        if(carry == 1) {
            int[] numbers = new int[digits.length + 1];
            numbers[0] = 1;
            return numbers;
        }
        return digits;

        }
}
