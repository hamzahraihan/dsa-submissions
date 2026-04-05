class Solution {
    /**
     * @param {number[]} digits
     * @return {number[]}
     */
    plusOne(digits) {
        let carry = 1;
        for(let i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                // sum digit with carry number
                let sum = digits[i] + carry;
                // set last digit to sum number
                // update sum using modulo
                digits[i] = sum % 10; 
                // set carry value to sum
                carry = sum;
                return digits;
            }
           digits[i] = 0;
           
           
        }
        digits.splice(0,0,1);
        return digits
    }
}
