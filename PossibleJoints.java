import java.util.*;

public class PossibleJoints {

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

    PossibleJoints() {
        root = new TrieNode(' ');
    }

    public void possibleJoints(String words[]) {
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            addWord(root, str);
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                printJoints(root.children[i]);
            }
        }
    }

    private void printJoints(TrieNode root) {
        if (root == null) {
            return;
        }
        if (root.count > 1) {
            System.out.println(root.data);
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                printJoints(root.children[i]);
            }
        }
    }

    private void addWord(TrieNode root, String str) {
        if (str.length() == 0) {
            root.isTerminating = true;
            return;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(str.charAt(0));
            root.children[childIndex] = child;
            root.count++;
        }
        addWord(child, str.substring(1));
    }

}
