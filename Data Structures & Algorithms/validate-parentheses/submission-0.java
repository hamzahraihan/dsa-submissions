class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> pair = new HashMap<>();
        pair.put('}','{');
        pair.put(']','[');
        pair.put(')','(');

        for(char c : s.toCharArray()){
            if(pair.containsKey(c)){
                if(stack.isEmpty() || stack.peek() != pair.get(c)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }
}
