public class MinimumTotal {
    // i dont know what i was thinking and i did dynamic programming and my
    // running time was only better 0.42% of the submissions soo i realized
    // instantly i was doing it wrong.
    // Here's how i crapped on this problem
    List<List<Integer>> t;

    public int minimumTotal(List<List<Integer>> triangle) {
        t = new ArrayList();

        for(int i = 1; i <= triangle.size(); i++) {
            t.add(IntStream
                    .range(0, i)
                    .map(x -> -1)
                    .boxed()
                    .collect(Collectors.toList()));
        }

        int min = minTotal(triangle, 0, 0);

        System.out.println(t);
        return t.get(0).get(0);
    }

    public int minTotal(List<List<Integer>> triangle, int row, int index) {
        if(row < triangle.size()) {
            if(index < triangle.get(row).size()) {

                if(t.get(row).get(index) == -1) {
                    int min = triangle.get(row).get(index) +
                            Math.min(minTotal(triangle, row + 1, index),
                             minTotal(triangle, row + 1, index + 1));

                    t.get(row).add(index, min);
                    return min;
                } else {
                    return t.get(row).get(index);
                }
            } else {
                return Integer.MAX_VALUE;
            }
        } else {
            return 0;
        }
    }

    // Here's how you actually do it. LOL stupid me. Djikstras is the one,
    // should have known better :(
    public int minimumTotal(List<List<Integer>> triangle) {

        final int size = triangle.size();
        if(size == 0) return 0;
        if(size == 1) return triangle.get(0).get(0);

        int[] s = new int[size];

        int i = 0;
        for(int v : triangle.get(size - 1)){
             s[i++] = v;
        }

        for(i = size - 2; i >=0 ; i--){
            List<Integer> step = triangle.get(i);

            // s[0] = min(s[0] + step[0], s[1] + step[0])

            for(int j = 0; j < step.size(); j++){
                s[j] = Math.min(step.get(j) + s[j], step.get(j) + s[j + 1]);
            }

        }

        return s[0];
    }
}
