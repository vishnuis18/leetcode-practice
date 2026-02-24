class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int,int> m;
        int size=nums.size();
        for(int i=0;i<size;i++){
            int number = nums[i];
            int remains = target - number;
            if (m.find(remains)!=m.end()){
                return {m[remains],i};
            }
            m[number]=i;
        }
        return{-1,1};
        
    }
};