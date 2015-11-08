public class PascalTrainglee {
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

    public List<List<Integer>> generate(int numRows) {

        ArrayList<List<Integer>> rt = new ArrayList<List<Integer>>();

        Integer[] prev = null;

        for(int i = 1 ; i <= numRows; i++){

            Integer[] row = new Integer[i];

            row[0] = 1;
            row[i - 1] = 1;

            for(int j = 1; j < i - 1 ; j++){
                //row.add(j, prev.get(j) + prev.get(j -1));
                row[j] = prev[j] + prev[j - 1];
            }

            rt.add(new ArrayList<Integer>(Arrays.asList(row)));
            prev = row;
        }


        return rt;

    }

}
