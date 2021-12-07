import java.util.*;

public class DistinctSubstrings {
	TrieNode root;

	DistinctSubstrings() {
		root = new TrieNode(' ');
	}

	public void distinctSubstrings(String str) {
		for (int i = 0; i < str.length(); i++) {
			addWord(str.substring(i, str.length()), root);
		}
		for (int i = 0; i < 26; i++) {
			if (root.children[i] != null) {
				printWord(root.children[i], "");
			}
		}
	}

	private void printWord(TrieNode root, String ans) {
		if (root == null) {
			return;
		}

		System.out.println(ans + root.data);

		for (int i = 0; i < 26; i++) {
			if (root.children[i] != null) {
				printWord(root.children[i], ans + root.data);
			}
		}
	}

	private void addWord(String str, TrieNode root) {
		if (str.length() == 0) {
			root.isTerminating = true;
			return;
		}
		int childIndex = str.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if (child == null) {
			child = new TrieNode(str.charAt(0));
			root.children[childIndex] = child;
		}
		addWord(str.substring(1), child);
	}

}
