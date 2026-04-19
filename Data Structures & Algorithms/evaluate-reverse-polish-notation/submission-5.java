class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(token.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }

            if(token.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }

            if(token.equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b * a);
            }

            if(token.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }

            if(!"+-*/".contains(token)){
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}
