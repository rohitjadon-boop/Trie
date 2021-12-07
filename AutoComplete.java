public class AutoComplete {
    private final TrieNode root;

    AutoComplete() {
        root = new TrieNode('\0');
    }

    public void autoComplete(String[] words, String autoCompleteTheWord) {
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            addWord(str, root);
        }
        search(autoCompleteTheWord, root, autoCompleteTheWord);
    }

    private void search(String str, TrieNode root, String originalWord) {
        if (str.length() == 0) {
            autoComplete(originalWord.substring(0, originalWord.length() - 1), root);
            return;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return;
        }
        search(str.substring(1), child, originalWord);
    }

    private void autoComplete(String str, TrieNode root) {
        if (root == null) {
            return;
        }

        if (root.isTerminating == true) {
            System.out.println(str + root.data);
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                autoComplete(str + root.data, root.children[i]);
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
