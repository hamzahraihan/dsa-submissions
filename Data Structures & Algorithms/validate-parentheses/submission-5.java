class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> pair = new HashMap<>();
        for(char ch : s.toCharArray()){
            pair.put(')', '('); 
            pair.put('}', '{'); 
            pair.put(']', '['); 
        }

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(pair.containsKey(s.charAt(i))){
                if(!stack.isEmpty() && stack.peek() == pair.get(s.charAt(i))){
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
