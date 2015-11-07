public class IsomorphicStrings {

    //again this is the inefficient way :( using HashMap and StringBuffer and
    //HashSet seems like taking too much memory already
    public boolean isIsomorphic(String s, String t) {
        if(s.length() == 0)
            return true;
        HashMap h = new HashMap();
        HashSet hs = new HashSet();
        StringBuffer tmp = new StringBuffer();
        for(int i=0; i<s.length(); i++) {
            if(h.containsKey(s.charAt(i))){
                tmp.append((char)h.get(s.charAt(i)));
            } else {
                tmp.append(t.charAt(i));
                h.put(s.charAt(i), t.charAt(i));
                hs.add(t.charAt(i));
            }
        }
        if(hs.size() != h.size())
            return false;
        return tmp.toString().equals(t);
    }

    //the more efficient way to do it using only HashMap
    public boolean isIsomorphic(String s, String t) {
        if(s==null || t==null)
            return false;

        if(s.length() != t.length())
            return false;

        if(s.length()==0 && t.length()==0)
            return true;

        HashMap<Character, Character> map = new HashMap<Character,Character>();
        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            Character c = getKey(map, c2);
            if(c != null && c!=c1){
                return false;
            }else if(map.containsKey(c1)){
                if(c2 != map.get(c1))
                    return false;
            }else{
                map.put(c1,c2);
            }
        }

        return true;
    }

    // a method for getting key of a target value -- cool!!, I did not know
    // this. This would be a much better alternative to what i did in the
    // beginning to handle revere mapping.
    public Character getKey(HashMap<Character,Character> map, Character target){
        // Map.Entry retrieves every entry of the hashmap!! cool (should know this  )
        for (Map.Entry<Character,Character> entry : map.entrySet()) {
            if (entry.getValue().equals(target)) {
                return entry.getKey();
            }
        }

        return null;
    }
}
