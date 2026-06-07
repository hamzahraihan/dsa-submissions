class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for(int i = 0; i < gas.length; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost) return -1;

        int start = 0, fuel = 0;
        for(int i = 0; i < gas.length; i++){
            if(fuel + gas[i] - cost[i] < 0){
                start = i + 1;  
                fuel = 0;
            } else {
                fuel += gas[i] - cost[i];
            }
        }
        return start;
    }
}
