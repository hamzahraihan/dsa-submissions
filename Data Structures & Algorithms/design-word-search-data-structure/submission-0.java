class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode(){
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }
}

class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(!node.children.containsKey(ch)){
                node.children.put(ch, new TrieNode());
            }
           node = node.children.get(ch);
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode node){
        if(j == word.length()) return node.isEndOfWord;

        char c = word.charAt(j);

        if(c == '.'){
            for(TrieNode child : node.children.values()){
                if(child != null && dfs(word, j + 1, child)){
                    return true;
                }
            }
            return false;
        } else {
            TrieNode child = node.children.get(c);
            if(child == null){
                return false;
            }
            return dfs(word, j + 1, child);
        }
    }
}
