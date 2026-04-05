class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums, target) {
        let container = new Map();
        for (let i = 0; i < nums.length; i++) {
            let diff = target - nums[i];
            if (container.has(diff)) {
                return [container.get(diff), i];
            }
            container.set(nums[i], i)

        }
    }
}
