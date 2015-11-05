public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()!=0){
            int maxLength = 1;
            HashMap h = new HashMap(256);
            int start = 0, length = 1;
            h.put(s.charAt(0), 0);
            for (int i = 1; i < s.length(); i++) {
                if (h.containsKey(s.charAt(i))) {
                    if (length > maxLength) {
                        maxLength = length;
                    }
                    length += (start - (int) h.get(s.charAt(i)));
                    int newstart = (int) h.get(s.charAt(i)) + 1;
                    for (int j = start; j < (int) h.get(s.charAt(i)); j++) {
                        h.remove(s.charAt(j));
                    }
                    start = newstart;
                    h.put(s.charAt(i), i);
                } else {
                    length++;
                    h.put(s.charAt(i), i);
                }
    
            }
            if(length>maxLength)
                return length;
            else
                return maxLength;
        } else {
            return 0;
        }
    }
}

