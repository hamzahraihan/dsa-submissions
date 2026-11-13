class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int,int> count;
        for(int num : nums){
            count[num] = 1 + count[num];
        }

        vector<vector<int>> bucket(nums.size() + 1);

        for(const auto& pair : count){
            bucket[pair.second].push_back(pair.first);
        }

        vector<int> res;
        for(int i = bucket.size() - 1; i >= 0; --i){
            for(int n : bucket[i]){
                res.push_back(n);
                if(res.size() == k){
                    return res;
                }
            }
        }
        return res;
    }
};
