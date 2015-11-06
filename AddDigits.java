public class AddDigits {

    //sub-optimal solutions
    public int addDigits2(int num) {
        if(num/10 == 0)
            return num;
        else {

            int sum = 0;
            while(num != 0){
                sum += num % 10;
                num = num/10;
            }
            return addDigits(sum);
        }
    }

    public int addDigits(int num) {
        return 1+(num-1)%9;
    }
}
