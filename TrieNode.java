public class TrieNode {
    char data;
    TrieNode children[];
    boolean isTerminating;
    int traverseCount;
    int num;

    TrieNode(char data) {
        this.data = data;
        children = new TrieNode[26];
        isTerminating = false;
        traverseCount = 0;
    }
}
