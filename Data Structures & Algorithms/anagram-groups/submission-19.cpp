class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
       unordered_map<string, vector<string>> hashmap; 
       for(const auto& str : strs){
            vector<int> count(26,0);
            for(char s : str){
                count[s - 'a']++;
            }
            string key = to_string(count[0]);
            for(int i = 1; i < count.size(); i++){
                key += ',' + to_string(count[i]);
            }
            hashmap[key].push_back(str);
       }

       vector<vector<string>> res;
       for(const auto& pair : hashmap){
            res.push_back(pair.second);
       }

       return res;
    }
};
