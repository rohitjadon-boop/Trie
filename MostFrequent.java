import java.util.*;

public class MostFrequent {

    String ans = "";
    int count = 0;

    public static class TrieNode {
        char data;
        boolean isTerminating;
        TrieNode children[];
        int count;

        TrieNode(char data) {
            this.data = data;
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    MostFrequent() {
        root = new TrieNode(' ');
    }

    public void mostFrequent(String words[]) {
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            addWord(str, root);
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                getPotentialAns(root.children[i], "");
            }
        }
        System.out.println(this.ans);
    }

    private void getPotentialAns(TrieNode root, String potentialAns) {
        if (root == null) {
            return;
        }

        if (root.isTerminating) {
            if (root.count > this.count) {
                ans = potentialAns + root.data;
                this.count = root.count;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                getPotentialAns(root.children[i], potentialAns + root.data);
            }
        }

    }

    private void addWord(String str, TrieNode root) {
        if (str.length() == 0) {
            root.isTerminating = true;
            root.count++;
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
