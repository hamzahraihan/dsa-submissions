class TrieNode{
    private Map<Character, TrieNode> children;
    private boolean isEnd;
    
    public TrieNode(){
        this.children = new HashMap<>();
        this.isEnd = false;
    }

    public void addWords(String word){
        TrieNode node = this;
        for(char ch : word.toCharArray()){
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEnd = true;
    } 
}

class Solution {

    TrieNode root;
    public boolean wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();
        for(String word : wordDict){
            root.addWords(word);
        }

        Boolean[] memo = new Boolean[s.length() + 1];

        return dfs(0, s, memo);
    }

    private boolean dfs(int start,String s, Boolean[] memo){
        if(start >= s.length()){
            return true;
        }

        if(memo[start] != null){
            return memo[start];
        }

        TrieNode node = root; 
        for(int i = start; i < s.length(); i++){
            char sChar = s.charAt(i);
            if(!node.children.containsKey(sChar)){
                break;
            }

            node = node.children.get(sChar);

            if(node.isEnd){
                if(dfs(i + 1, s, memo)){
                    memo[start] = true;
                    return true;
                }
            }
        }

        memo[start] = false;
        return false;
    }
}
