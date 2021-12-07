public class WordBreak {

    TrieNode root;

    WordBreak() {
        root = new TrieNode('\0');
    }

    public boolean addWord(String[] dictionary, String word) {
        for (int i = 0; i < dictionary.length; i++) {
            String str = dictionary[i];
            addWord(root, str);
        }
        return wordBreak(word);
    }

    private boolean wordBreak(String str) {
        if (str.length() == 0) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            String subString = str.substring(0, i + 1);
            if (search(root, subString) && wordBreak(str.substring(i + 1))) {
                return true;
            }
        }
        return false;
    }

    private boolean search(TrieNode root, String str) {
        if (str.length() == 0) {
            if (root.isTerminating) {
                return true;
            }
            return false;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return false;
        }
        boolean ans = search(child, str.substring(1));
        if (ans == false) {
            return false;
        }
        return true;
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
        }
        addWord(child, str.substring(1));
    }
}
