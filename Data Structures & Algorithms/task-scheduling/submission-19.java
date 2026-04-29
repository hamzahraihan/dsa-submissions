class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(int i = 0; i < tasks.length; i++){
            count[tasks[i] - 'A']++;
        }

        Arrays.sort(count);
        int maxf = count[25];
        int idle = (maxf - 1) * n;

        for(int i = 24; i >= 0; i--){
            idle -= Math.min(maxf - 1, count[i]);
        }
        return Math.max(0, idle) + tasks.length;
    }
}
