public class ExcelTitleNumber {
    public String convertToTitle(int n) {
        if(n==0) return "";
        StringBuilder sb = new StringBuilder();
        while(n != 0) {

            if(n%26 == 0) {
              sb.append('Z');
              n--;
            } else sb.append((char)((n % 26) + 64));

            n = n/26;
        }
        sb.reverse();
        return sb.toString();
    }

    public String convertToTitle(int n) {
        if(n < 27){
          return (char)('A' + (n - 1)) + "";
        }

        if( n % 26 == 0) {
          return convertToTitle(n / 26 - 1) + 'Z';
        }

        return convertToTitle(n / 26) + convertToTitle(n % 26);
    }
}
