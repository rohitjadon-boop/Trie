public class UniqueRows {
    static TrieNode root = new TrieNode(' ');

    UniqueRows() {
        root = new TrieNode(' ');
    }

//    public static void main(String[] args) {
//
//        addMatrix(arr);
//    }

    public static void addMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            String str = "";
            for (int j = 0; j < arr[0].length; j++) {
                str += arr[i][j];
            }
            boolean isWordPresent = searchWord(str, root);
            if (isWordPresent == false) {
                addWord(str, root);
                System.out.println(str);
            }
        }
    }

    private static boolean searchWord(String str, TrieNode root) {
        if (str.length() == 0) {
            return root.isTerminating;
        }
        int childIndex = str.charAt(0) - '0';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return false;
        }
        boolean isPresent = searchWord(str.substring(1), child);
        return isPresent != false;
    }

    private static void addWord(String str, TrieNode root) {
        if (str.length() == 0) {
            root.isTerminating = true;
            return;
        }
        int childIndex = str.charAt(0) - '0';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(str.charAt(0));
            root.children[childIndex] = child;
        }
        addWord(str.substring(1), child);
    }

    public static class TrieNode {
        char data;
        boolean isTerminating;
        TrieNode[] children;

        TrieNode(char data) {
            this.data = data;
            children = new TrieNode[2];
            isTerminating = false;
        }
    }
}
