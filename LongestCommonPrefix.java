public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int i = 1;
        String prefix;

        if(strs.length > 0) {
            if(strs[0].length() > 0)
                prefix = strs[0].substring(0,1);
            else
                return "";
        } else {
            return "";
        }

        while(i<=strs[0].length()){
            prefix = strs[0].substring(0,i);
            for(int j = 1; j < strs.length; j++) {
                if(!strs[j].startsWith(prefix))
                    return prefix.substring(0,i-1);
            }
            i++;
        }
        return prefix.substring(0,i-1);
    }
    // The better way could be to check character by character :) less number of
    // strings literals will be created in the string constant pool.

}
