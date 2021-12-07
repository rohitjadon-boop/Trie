import java.util.ArrayList;

public class PhoneDictionary {
    static TrieNode root;

    PhoneDictionary() {
        root = new TrieNode('\0');
    }

    static ArrayList<ArrayList<String>> displayContacts(int n, String[] contact, String s) {
        for (int i = 0; i < contact.length; i++) {
            String str = contact[i];
            addWord(root, str);
        }
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            ArrayList<String> l = new ArrayList<>();
            searchWord(s.substring(0, i + 1), root, l, s.substring(0, i + 1));
            if (l.size() > 0) {
                list.add(l);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add("0");
                list.add(temp);
            }
        }
        return list;
    }

    private static void searchWord(String str, TrieNode root, ArrayList<String> list, String original) {
        if (str.length() == 0) {
            autoComplete(root, original.substring(0, original.length() - 1), list);
            return;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return;
        }
        searchWord(str.substring(1), child, list, original);
    }

    private static void autoComplete(TrieNode root, String str, ArrayList<String> list) {
        if (root == null) {
            return;
        }
        if (root.isTerminating == true) {
            list.add(str + root.data);
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                autoComplete(root.children[i], str + root.data, list);
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
