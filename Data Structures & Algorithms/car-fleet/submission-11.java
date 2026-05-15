class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // pair a position[0] and speed[1]
        int[][] pair = new int[position.length][2];
        for(int i = 0; i < position.length; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        // sort the pair so we can proceed with the most closest target
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();

        for(int[] p : pair){
            stack.push((double) (target - p[0]) / p[1]);
            // if we saw the new car that has time is less or equal to the time before it
            // then it will catches up and merge with that fleet
            if(stack.size() >= 2  && stack.peek() <= stack.get(stack.size() - 2)){
                stack.pop();
            }
        }

        return stack.size();
    }
}
