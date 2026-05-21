class Solution {

    class TrieNode {

        TrieNode[] children = new TrieNode[26];

        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();

        TrieNode root = buildTrie(words);

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    public void dfs(char[][] board, int i, int j,
                    TrieNode node, List<String> result) {

        // Boundary check
        if (i < 0 || j < 0 ||
            i >= board.length || j >= board[0].length) {

            return;
        }

        char c = board[i][j];

        // Visited or not in trie
        if (c == '#' || node.children[c - 'a'] == null) {

            return;
        }

        node = node.children[c - 'a'];

        // Word found
        if (node.word != null) {

            result.add(node.word);

            // Avoid duplicates
            node.word = null;
        }

        // Mark visited
        board[i][j] = '#';

        dfs(board, i + 1, j, node, result);
        dfs(board, i - 1, j, node, result);
        dfs(board, i, j + 1, node, result);
        dfs(board, i, j - 1, node, result);

        // Restore
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {

        TrieNode root = new TrieNode();

        for (String word : words) {

            TrieNode current = root;

            for (char c : word.toCharArray()) {

                int index = c - 'a';

                if (current.children[index] == null) {

                    current.children[index] = new TrieNode();
                }

                current = current.children[index];
            }

            current.word = word;
        }

        return root;
    }
}