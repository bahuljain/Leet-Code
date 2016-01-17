class TrieNode {
	// Initialize your data structure here.
	Map<Character, TrieNode> children;
	boolean end = false;

	public TrieNode() {
		children = new HashMap<>();
	}
}

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		add(this.root, word, 0);
	}

	private void add(TrieNode root, String word, int pos) {
		if (pos < word.length()) {
			char c = word.charAt(pos);

			if (root.children.containsKey(c)) {
				add(root.children.get(c), word, pos + 1);
			} else {
				TrieNode child = new TrieNode();
				root.children.put(c, child);
				add(child, word, pos + 1);
			}
		} else {
			root.end = true;
		}
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		return search(root, word, 0);
	}

	private boolean search(TrieNode root, String word, int pos) {
		if (pos == word.length()) {
			return (root.end) ? true : false;
		} else {
			if (root.children.isEmpty())
				return false;
			else {
				char key = word.charAt(pos);
				return (root.children.containsKey(key)) ? search(root.children.get(key), word, pos + 1) : false;
			}
		}
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		return startsWith(root, prefix, 0);
	}

	private boolean startsWith(TrieNode root, String prefix, int pos) {
		if (pos == prefix.length()) {
			return true;
		} else {
			if (root.children.isEmpty())
				return false;
			else {
				char key = prefix.charAt(pos);
				return (root.children.containsKey(key)) ? startsWith(root.children.get(key), prefix, pos + 1) : false;
			}
		}
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
