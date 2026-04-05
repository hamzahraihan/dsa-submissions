class Solution {
    /**
     * @param {number[]} nums
     * @return {number[][]}
     */
    permute(nums) {
        let res = []

        function backtrack(used = [], permutation = []){
            if(permutation.length == nums.length){
                res.push(Array.from(permutation))
                return
            }
            for(let i = 0; i < nums.length; i++){
                if(used[i] == true)continue
                used[i] = true
                permutation.push(nums[i])
                backtrack(used,permutation)
                used[i] = false
                permutation.pop()
            }
        }
        backtrack()
        return res;
    }
}
