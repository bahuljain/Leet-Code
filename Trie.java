class TrieNode {
	// Initialize your data structure here.

	// Since we already know that every string can only contain a-z characters
	// we can simply make an array of size 26 for every character improving on
	// time efficiency but if the words are sparse in usage of characters it
	// could be more space efficient to use a map. Either ways its correct :)

	// With array the running time is better than 65% submissions
	// With map the running time is better than 37% submission

	TrieNode[] children;
	boolean end = false, empty = true;

	public TrieNode() {
		children = new TrieNode[26];
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
			int c = word.charAt(pos) - 97;

			if (root.children[c] != null) {
				add(root.children[c], word, pos + 1);
			} else {
				TrieNode child = new TrieNode();
				root.children[c] = child;
				root.empty = false;
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
			if (root.empty)
				return false;
			else {
				int x = word.charAt(pos) - 97;
				return (root.children[x] != null) ? search(root.children[x], word, pos + 1) : false;
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
			if (root.empty)
				return false;
			else {
				int x = prefix.charAt(pos) - 97;
				return (root.children[x] != null) ? startsWith(root.children[x], prefix, pos + 1) : false;
			}
		}
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
