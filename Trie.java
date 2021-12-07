public class Trie {
    private TrieNode root;
    private int totalWordsCount;

    Trie() {
        root = new TrieNode(' ');
    }

    public void addString(String str) {
        addString(root, str);
    }

    private void addString(TrieNode root, String str) {
        if (str.length() == 0) {
            root.isTerminating = true;
            totalWordsCount++;
            return;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(str.charAt(0));
            root.children[childIndex] = child;
        }
        addString(child, str.substring(1));
    }

    public boolean searchString(String str) {
        return searchString(root, str);
    }

    private boolean searchString(TrieNode root, String str) {
        if (str.length() == 0) {
            if (root.isTerminating == true) {
                return true;
            }
            return false;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return false;
        }
        boolean ans = searchString(child, str.substring(1));
        if (ans == false) {
            return false;
        }
        return true;
    }

    public void deleteString(String str) {
        deleteString(root, str);
    }

    private void deleteString(TrieNode root, String str) {
        if (str.length() == 0) {
            if (root.isTerminating == true) {
                totalWordsCount--;
                root.isTerminating = false;
            }
            return;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return;
        }
        deleteString(child, str.substring(1));
        if (child.isTerminating == false) {
            int count = 0;
            for (int i = 0; i < 26; i++) {
                if (child.children[i] != null) {
                    count += 1;
                }
            }
            if (count == 0) {
                root.children[childIndex] = null;
            }
        }
    }

    public int countWords() {
        return totalWordsCount;
    }

    public void printWords() {
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                printWords(root.children[i], "");
            }
        }
    }

    private void printWords(TrieNode root, String ans) {
        if (root == null) {
            return;
        }
        if (root.isTerminating) {
            System.out.println(ans + root.data);
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                printWords(root.children[i], ans + root.data);
            }
        }
    }
}
