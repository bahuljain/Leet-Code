public class Solution {
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits.length() == 0 || digits.indexOf('1') > -1)
			return res;

		Map<Character, String> keyPad = new HashMap<>();
		createMap(keyPad);
		char[] ch = new char[digits.length()];

		combine(digits, 0, ch, res, keyPad);
		return res;
	}

	public void combine(String digits, int n, char[] ch, List<String> res, Map<Character, String> keyPad) {
		if (n != digits.length()) {
			String list = keyPad.get(digits.charAt(n));
			for (int i = 0; i < list.length(); i++) {
				ch[n] = list.charAt(i);
				combine(digits, n + 1, ch, res, keyPad);
			}

		} else {
			res.add(new String(ch));
		}
	}

	public void createMap(Map<Character, String> keyPad) {
		keyPad.put('0', " ");
		keyPad.put('2', "abc");
		keyPad.put('3', "def");
		keyPad.put('4', "ghi");
		keyPad.put('5', "jkl");
		keyPad.put('6', "mno");
		keyPad.put('7', "pqrs");
		keyPad.put('8', "tuv");
		keyPad.put('9', "wxyz");
	}
}
