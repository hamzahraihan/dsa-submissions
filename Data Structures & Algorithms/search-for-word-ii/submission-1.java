// create a trie data structure to store each character from words
class TrieNode {
    private Map<Character, TrieNode> children;
    private boolean isEnd;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isEnd = false;
    }

    // create a method to store character to each node
    public void addWords(String words){
        TrieNode node = this;
        for(char ch : words.toCharArray()){
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }
}

class Solution {
    private Set<String> res;
    private boolean[][] visit; 

    // find a word using dfs
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode node = new TrieNode();
        for(String word: words){
            node.addWords(word);
        }

        int rows = board.length, cols = board[0].length;
        res = new HashSet<>();
        visit = new boolean[rows][cols];
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                dfs(board, r, c, node, "");
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, String word){
        int rows = board.length, cols = board[0].length;
        // create a condition if row or c is out of bound or board is already visited, or there is no character inside node
        if(r < 0 || c < 0 || r >= rows || c >= cols || visit[r][c] || !node.children.containsKey(board[r][c])){
            return;
        }

        visit[r][c] = true;
        node = node.children.get(board[r][c]);
        word += board[r][c];
        if(node.isEnd){
            res.add(word);
        }

        dfs(board, r + 1, c, node, word);
        dfs(board, r - 1, c, node, word);
        dfs(board, r, c + 1, node, word);
        dfs(board, r, c - 1, node, word);

        visit[r][c] = false;
    }
}
