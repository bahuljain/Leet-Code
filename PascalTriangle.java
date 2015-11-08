public class PascalTraingle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pas = new ArrayList<>();

        if(numRows == 0) return pas;

        List<Integer> level = new ArrayList();
        level.add(0); level.add(1); level.add(0);
        pas.add(new ArrayList<Integer>(level)); level.clear();

        int row = 1;
        while(row < numRows) {
            int tmp = 0;
            for (int i : pas.get(row-1)){
                level.add(tmp+i);
                tmp = i;
            }
            level.add(0);
            pas.add(new ArrayList<Integer>(level));
            level.clear();
            row++;
        }

        List<Integer> cleaner = new ArrayList();
        cleaner.add(0); cleaner.add(0);
        for (List<Integer> l : pas){
            l.removeAll(cleaner);
        }

        return pas;
    }
}
