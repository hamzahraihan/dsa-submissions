class Solution {
    public int evalRPN(String[] tokens) {
        List<String> tokenList = new ArrayList<>(Arrays.asList(tokens));
        return dfs(tokenList);
    }

    private int dfs(List<String> tokens){
        String token = tokens.remove(tokens.size() - 1);

        if(!"+-*/".contains(token)){
            return Integer.parseInt(token);
        }

        int left = dfs(tokens);
        int right = dfs(tokens);

        switch(token){
            case "+":
                return left + right;
            case "-":
                return right - left;
            case "/":
                return right / left;
            case "*":
                return left * right;
        }

        return 0;
    }
}
