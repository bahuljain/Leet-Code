public class StrStr {

    //using string functions (which uses KMP)
    public int strStr1(String haystack, String needle) {
        try {
            return haystack.indexOf(needle);
        }catch(Exception e) {
            return -1;
        }
    }

    // brute force (good enough for interview)
    public int strStr(String haystack, String needle) {
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean flag = true;
            for(int j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if(flag) return i;
        }
        return -1;
    }

    // but als mention KMP, Rabin-Karp, Boyer-Moore
}
