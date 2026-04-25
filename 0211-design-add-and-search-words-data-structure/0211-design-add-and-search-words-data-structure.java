class WordDictionary {

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Add word
    public void addWord(String word) {

        TrieNode node = root;

        for (char c : word.toCharArray()) {

            int index = c - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.isEnd = true;
    }

    // Search word with '.' wildcard
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int pos, TrieNode node) {

        if (node == null)
            return false;

        if (pos == word.length())
            return node.isEnd;

        char c = word.charAt(pos);

        // Normal character
        if (c != '.') {

            int index = c - 'a';

            return dfs(word, pos + 1,
                       node.children[index]);
        }

        // Dot case — try all children
        for (int i = 0; i < 26; i++) {

            if (node.children[i] != null &&
                dfs(word, pos + 1,
                    node.children[i])) {

                return true;
            }
        }

        return false;
    }
}