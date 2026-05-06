class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode(){
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }
}
class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
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
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(!node.children.containsKey(ch)){
                return false;
            }
            node = node.children.get(ch);
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char ch : prefix.toCharArray()){
            if(!node.children.containsKey(ch)){
                return false;
            }
            node = node.children.get(ch);
        }
        return true;
    }
}
