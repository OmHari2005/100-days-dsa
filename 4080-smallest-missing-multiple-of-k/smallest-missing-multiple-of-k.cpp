    int fun(vector<int>& nums,int k, int multiple) {
        for(int i=0;i<nums.size();i++){
            if(nums[i]==multiple){
            return fun(nums,k,multiple + k);
        }
        
    }
    return multiple;
    }
    class Solution {
        public:
        int missingMultiple(vector<int>&nums,int k){
            return fun(nums,k,k);
        }
    };
