// two pointer solution O(1)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++){
            int l = 1 + i, r = numbers.length - 1;
            
            int complement = target - numbers[i];
            while(l <= r){
                int mid = (l + r) / 2;
                if(numbers[mid] == complement){
                    return new int[]{i + 1, mid + 1};
                } else if(numbers[mid] < complement){
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return new int[0];
    }
}
