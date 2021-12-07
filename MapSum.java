import java.util.HashMap;
class MapSum {
    TrieNode root = new TrieNode(' ');
    HashMap<String, Integer> map = new HashMap<>();
    public MapSum() {
        // root = new TrieNode(' ');
        // map = new HashMap<>();
    }

    public void insert(String key, int val) {
        if(map.containsKey(key) == true) {
            replaceWord(key, val, root, map.get(key));
        }
        else {
            addWord(key, val, root);
        }
        map.put(key, val);
    }

    private void addWord(String str, int val, TrieNode root) {
        if(str.length() == 0) {
            root.isTerminating = true;
            return;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            child = new TrieNode(str.charAt(0));
            root.children[childIndex] = child;
        }
        int previousValue = child.num + val;
        child.num = previousValue;
        addWord(str.substring(1), val, child);
    }

    private void replaceWord(String str, int val, TrieNode root, int previousValue) {
        if(str.length() == 0) {
            root.isTerminating = true;
            return;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            child = new TrieNode(str.charAt(0));
            root.children[childIndex] = child;
        }
        child.num = child.num - previousValue + val;
        replaceWord(str.substring(1), val, child, previousValue);
    }

    public int sum(String prefix) {
        return prefixSum(prefix, root);
    }

    private int prefixSum(String str, TrieNode root) {
        if(str.length() == 0) {
            return root.num;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            return 0;
        }
        int ans = prefixSum(str.substring(1), child);
        return ans;

    }
}
