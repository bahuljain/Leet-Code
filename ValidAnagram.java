public class ValidAnagram {
    // shitty method.. obviously i didnt know better back then
    // can use hashmaps as a better alternative
    public boolean isAnagram(String s, String t) {
        //97-122
        if(s.length() != t.length()) {
            return false;
        } else {
            int[] count = new int[26];
            for(int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 97]++;
                count[t.charAt(i) - 97]--;
            }

            for(int i = 0; i < 26; i++) {
                if(count[i] != 0) return false;
            }
            return true;
        }
    }
}
