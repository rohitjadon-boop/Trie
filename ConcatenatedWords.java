import java.util.*;

public class ConcatenatedWords {
    public static class TrieNode {
        char data;
        boolean isTerminating;
        TrieNode children[];

        TrieNode(char data) {
            this.data = data;
            children = new TrieNode[26];
        }
    }

    static TrieNode root = new TrieNode(' ');

//    ConcatenatedWords() {
//        root = new TrieNode(' ');
//    }


    public static void concatenateWords(String words[]) {
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            addWord(root, str);
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                searchWord(root.children[i], root, "");
            }
        }
    }

    private static void searchWord(TrieNode root, TrieNode currentRoot, String potentialAns) {
        if (root == null) {
            return;
        }

        if (root.isTerminating == true) {
//            System.out.println("Inside");
            searchForValidConcatenation(root, currentRoot, potentialAns + root.data);
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                searchWord(root.children[i], currentRoot, potentialAns + root.data);
            }
        }
    }

    private static void searchForValidConcatenation(TrieNode currentRoot, TrieNode root, String potentialAns) {

        if (root == null || currentRoot == null) {
            return;
        }

        if (root.isTerminating && currentRoot.isTerminating) {
            System.out.println(potentialAns + root.data);
        }

        for (int i = 0; i < 26; i++) {
            if (currentRoot.children[i] != null && root.children[i] != null) {
                searchForValidConcatenation(currentRoot.children[i], root.children[i], potentialAns + root.data);
            }
        }
    }

    private static void addWord(TrieNode root, String str) {
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
        addWord(child, str.substring(1));
    }

}
