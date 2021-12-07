public class SortingWords {

	TrieNode root;

	SortingWords() {
		root = new TrieNode(' ');
	}

	public void sortWord(String[] words) {
		for (int i = 0; i < words.length; i++) {
			String str = words[i];
			addWord(str, root);
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
		if (root.isTerminating == true) {
			for (int i = 0; i < root.traverseCount; i++) {
				System.out.println(ans + root.data);
			}
		}
		for (int i = 0; i < 26; i++) {
			if(root.children[i] != null) {
				printWord(root.children[i], ans + root.data);
			}
		}
	}

	public void addWord(String str, TrieNode root) {
		if (str.length() == 0) {
			root.isTerminating = true;
			root.traverseCount++;
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
