class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++){
            int l = 1 + i, r = numbers.length - 1;
            int complement = target - numbers[i];
            while(l <= r){
                // System.out.println("left index = " + l);
                // System.out.println("right index = " + r);
                int mid = l + (r - l) / 2;
                // System.out.println("mid index = " + mid);
                if( numbers[mid] < complement ){
                    l = mid + 1;
                }else if( numbers[mid] > complement ){
                    r = mid - 1;
                }else {
                    return new int[] { i + 1, mid + 1};
                }
            }
        }
        return new int[] { };
    }
}
