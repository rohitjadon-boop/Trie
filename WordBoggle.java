import java.util.*;

public class WordBoggle {
	TrieNode root;

	WordBoggle() {
		root = new TrieNode(' ');
	}

	public void boogleWord(String dictionary[], char arr[][]) {
		for (int i = 0; i < dictionary.length; i++) {
			String str = dictionary[i];
			addWord(str, root);
		}

		boolean visited[][] = new boolean[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				searchWord(visited, root, "", i, j, arr);
			}
		}
	}

	private void searchWord(boolean visited[][], TrieNode root, String ans, int row, int col, char arr[][]) {
		if (row < 0 || row > arr.length - 1 || col < 0 || col > arr[0].length - 1 || visited[row][col]) {
			return;
		}

		if(root == null) {
			return;
		}

		int childIndex = arr[row][col] - 'A';
		TrieNode child = root.children[childIndex];

		if(child == null) {
			return;
		}

		if(child.isTerminating == true) {
			System.out.println(ans + child.data);
		}

		visited[row][col] = true;
		searchWord(visited, child, ans + child.data, row + 1, col + 1, arr);
		searchWord(visited, child, ans + child.data, row , col + 1, arr);
		searchWord(visited, child, ans + child.data, row - 1, col + 1, arr);
		searchWord(visited, child, ans + child.data, row + 1, col , arr);
		searchWord(visited, child, ans + child.data, row + 1, col - 1, arr);
		searchWord(visited, child, ans + child.data, row , col - 1, arr);
		searchWord(visited, child, ans + child.data, row - 1, col - 1, arr);
		searchWord(visited, child, ans + child.data, row - 1, col , arr);
		visited[row][col] = false;
	}

	private void addWord(String str, TrieNode root) {
		if (str.length() == 0) {
			root.isTerminating = true;
			return;
		}
		int childIndex = str.charAt(0) - 'A';
		TrieNode child = root.children[childIndex];
		if (child == null) {
			child = new TrieNode(str.charAt(0));
			root.children[childIndex] = child;
		}
		addWord(str.substring(1), child);
	}
}
