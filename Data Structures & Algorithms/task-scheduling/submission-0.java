class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(int i = 0; i < tasks.length; i++){
            count[tasks[i] -  'A']++;
        }

        Arrays.sort(count);
        int maxF = count[25];
        int idle = (maxF - 1) * n;
        for(int i = 24; i >= 0; i--){
            idle -= Math.min(maxF - 1, count[i]);
        }

        return Math.max(0, idle) + tasks.length;
    }
}
