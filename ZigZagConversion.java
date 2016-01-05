public class Solution {
	public String convert(String s, int numRows) {
		if (numRows == 0) return null;
		if (numRows == 1) return s;

		StringBuffer[] zz = new StringBuffer[numRows];
		for (int i = 0; i < numRows; i++) {
			zz[i] = new StringBuffer();
		}

		int row = 0, step = 1;

		for (int i = 0; i < s.length(); i++) {
			if (row == 0) step = 1;
			if (row == numRows - 1) step = -1;

			zz[row].append(s.charAt(i));
			row += step;
		}

		return Arrays
				.stream(zz)
				.reduce((sb1, sb2) -> sb1.append(sb2))
				.get()
				.toString();
	}

	// much faster
	public String convert(String s, int numRows) {
	    if(numRows == 1) return s;
	    int gap = (numRows-1)<<1;
	    StringBuilder result = new StringBuilder();
	    for(int i=0; i<numRows; i++) {
	        int current = i;
	        int offset = gap - (i<<1);
	        while(current<s.length()) {
	            if( offset != 0 ) {
	                // avoid inserting duplicate elements
	                // in the first and the last row
	                result.append(s.charAt(current));

	                current += offset;
	            }
	            offset = gap-offset;
	        }
	    }

	    return result.toString();
	}
}
