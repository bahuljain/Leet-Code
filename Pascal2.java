public class Pascal2 {
    //this is what i did - cant believe i came up with such a lovely logic but
    //surprisingly it wasnt the best. Either ways i used map reduce in this and
    //i am quite satisfied with it. :)
    //Start with 1 -> 10 + 01 = 11 -> 110 + 011 = 121 -> 0121 + 1210 -> 1331...
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList();
        row.add(1);
        while(rowIndex-- > 0)
            row = nextLevel(row);
        return row;
    }

    public List<Integer> nextLevel(List<Integer> row) {
        List<Integer> row2 = new ArrayList(new ArrayList(row));
        row.add(0, 0);
        row2.add(0);

        return IntStream.range(0, row.size())
         .mapToObj(i -> row.get(i) + row2.get(i))
         .collect(Collectors.toList());
    }

    // and to my disappointment this turned out to be sweetest piece of code and
    // logic :( Quite brilliant to be honest :O
    public List<Integer> getRow(int rowIndex) {
        Integer[] row = new Integer[rowIndex + 1];

        Arrays.fill(row, 1);

        for(int i = 0 ; i < rowIndex - 1; i++){
            for(int j = i + 1; j >= 1; j--){
                row[j] = row[j] + row[j - 1];
            }
        }

        return Arrays.asList(row);
    }
}
