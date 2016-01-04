public class Solution {
    // faster solution
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] perm = new char[n*2];
        perms(n, n, perm, 0, res);
        return res;
    }

    private void perms(int open, int close, char[] perm, int i, List<String> res) {
        if (i == perm.length) {
            res.add(new String(perm));
            return;
        }
        // number of closing brackets should always be >= number of opening
        // brackets. If in any sequence the number of closing brackets
        // become more in number than the opening bracket the sequence will be
        // never be completed.
        if (open > 0 && close >= open) {
            perm[i] = '(';
            perms(open - 1, close, perm, i+1, res);
        }

        if (close > 0) {
            perm[i] = ')';
            perms(open, close - 1, perm, i+1, res);
        }
    }

    //very slow and memory inefficient
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();

        Set<String> prev = new HashSet<>();
        prev.add("()");

        Set<String> cur = new HashSet<>();

        for (int i = 2; i <= n; i++) {
            for (String s : prev) {
                cur.add("()" + s);
                cur.add(s + "()");
                for (int j = 0; j < s.length(); j++) {
                    String c = s.substring(0, j+1) + "()" + s.substring(j+1);
                    cur.add(c);
                }
            }

            prev.clear();
            prev.addAll(cur);
            cur.clear();

            System.out.println(prev);
        }

        return prev.stream().collect(Collectors.toList());
    }
}
