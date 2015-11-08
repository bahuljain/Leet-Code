public class CompareVersion {

    // finally this was one code I did better than tg123 (I hope)
    public int compareVersion(String version1, String version2) {

        ArrayList<String> v1 = new ArrayList(Arrays.asList(version1.split("\\.")));
        ArrayList<String> v2 = new ArrayList(Arrays.asList(version2.split("\\.")));

        if(v1.size() < v2.size()) while(v2.size() > v1.size())    v1.add("0");
        if(v2.size() < v1.size()) while(v1.size() > v2.size())    v2.add("0");

        for(int i=0; i < v1.size(); i++) {
            if(Integer.parseInt(v1.get(i)) > Integer.parseInt(v2.get(i))) return 1;
            if(Integer.parseInt(v1.get(i)) < Integer.parseInt(v2.get(i))) return -1;
        }

        return 0;
    }
}
