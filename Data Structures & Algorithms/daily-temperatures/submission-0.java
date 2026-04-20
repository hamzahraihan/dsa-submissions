class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for(int i = 0;  i < temperatures.length; i++){
            int count = 1;
            int j = i + 1;
            while(j < temperatures.length){
                if(temperatures[i] < temperatures[j]){
                    break;
                } 
                j++;
                count++;
            }
            count = (j == temperatures.length) ? 0 : count;
            res[i] = count;
        }
        return res;
    }
}
