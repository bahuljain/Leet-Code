public class IntToRoman {
    // this method could run faster if arrays are used instead of HashMap
    public String intToRoman(int num) {
        Map<Integer, Character> h = new HashMap();
        h.put(1, 'I'); h.put(5, 'V'); h.put(10, 'X'); h.put(50, 'L'); h.put(100, 'C'); h.put(500, 'D'); h.put(1000, 'M');

        String roman = ""; int pow = 0;
        while (num != 0) {
            int tmp = num % 10;
            if (tmp == 4) {
                roman = h.get((int) Math.pow(10, pow)) + "" + h.get(5 * (int) Math.pow(10, pow)) + roman;
            } else if (tmp == 9) {
                roman = h.get((int) Math.pow(10, pow)) + "" + h.get(10 * (int) Math.pow(10, pow)) + roman;
            } else {
                String tmp2 = "";
                while (tmp != 0) {
                    if (tmp >= 5) {
                        tmp2 += h.get(5 * (int) Math.pow(10, pow));
                        tmp -= 5;
                    } else {
                        tmp2 += h.get((int) Math.pow(10, pow));
                        tmp -= 1;
                    }
                }
                roman = tmp2 + roman;
            }
            pow++;
            num = num / 10;
        }

        return roman;
    }
}
