class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                // sum digit with carry number
                int sum = digits[i] + carry;
                // set last digit to sum number
                digits[i] = sum % 10;
                carry = sum;
                return digits;
            }
           digits[i] = 0;
        }
        int[] newdigits = new int[digits.length+1];
        newdigits[0] = 1;
        return newdigits; 
    }
}
