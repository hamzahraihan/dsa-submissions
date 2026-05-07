// create a trie data structure
class TrieNode {
    private Map<Character, TrieNode> children;
    private boolean isEnd;

    public TrieNode(){
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}

class WordDictionary {
    // create an instance for TrieNode
    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    // add each character to trie node
    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        // each end of the word, mark isEnd as true 
        node.isEnd = true;
    }

    // search each word using depth first search
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode node){
        // base case, if we are searching a word and reaching the end of a word return node isEnd
        if(j == word.length()) return node.isEnd;

        char c = word.charAt(j);

        // search for every dots '.' can be matched with any character  
        if(c == '.'){
            // find if the child still has value, and every child using depth first search is also has value then return true
            for(TrieNode child : node.children.values()){
                if(child != null && dfs(word, j + 1, child)){
                    return true;
                }
            }
            return false;
        } else { 
            // if not a dots '.', check if node is null we return false otherwise we keep doing depth first search 
            // until we reach the end of word
            if(node.children.get(c) == null){
                return false;
            }
            return dfs(word,j + 1, node.children.get(c));
        }
    }
}
