package hot100.Solution54;

public class Trie {
    Trie[] children;
    boolean isWord = false;


    public Trie() {
        children = new Trie[26];
    }

    public void insert(String word) {
        Trie root = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (root.children[c - 'a'] == null) {
                root.children[c - 'a'] = new Trie();
                root = root.children[c - 'a'];
            } else {
                root = root.children[c - 'a'];
            }
        }
        root.isWord = true;
    }

    public boolean search(String word) {
        Trie root = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (root.children[c - 'a'] == null) {
                return false;
            } else {
                root = root.children[c - 'a'];
            }
        }
        if (root.isWord) {
            return true;
        } else {
            return false;
        }
    }

    public boolean startsWith(String prefix) {
        Trie root = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (root.children[c - 'a'] == null) {
                return false;
            } else {
                root = root.children[c - 'a'];
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */