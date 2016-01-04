public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> codes = new ArrayList<>();
		if (n <= 0)
			return codes;

		codes.add(0);

		List<Integer> seq = new ArrayList<>();
		seq.add(0);

		int x = 0, j = 0;
		BitSet b = new BitSet(n);

		for (int i = 0; i < Math.pow(2, n) - 1; i++) {

			if ((Math.log(i+2)/Math.log(2))%1 == 0) {
				seq.add((int)(Math.log(i+2)/Math.log(2)));
			}

			int pos = seq.get(j++);
			System.out.println(pos);
			x += (b.get(pos)) ? -Math.pow(2, pos) : Math.pow(2, pos);
			b.flip(pos);
			codes.add(x);
			seq.add(pos);

			if ((Math.log(i)/Math.log(2)) == pos) {
				j = 0;
			}

		}

		System.out.println(seq);
		System.out.println(codes);

		return null;
	}
/*
	public static List<Integer> grayCode(int n) {
	    if (n < 0)
	        return new ArrayList<Integer>();
	    if (n == 0) {
	        List<Integer> list = new ArrayList<Integer>();
	        list.add(0);
	        return list;
	    }
	    List<Integer> tmp = grayCode(n - 1);
	    List<Integer> result = new ArrayList<Integer>(tmp);
	    int addNumber = 1 << (n - 1);
	    for (int i = tmp.size() - 1; i >= 0; i--) {
	        result.add(addNumber + tmp.get(i));
	    }

	    return result;
	}
*/

}
