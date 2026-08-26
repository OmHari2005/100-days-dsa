void fun(vector<int>&nums,vector<int>&tmp,vector<int>&ans){
        if (tmp.size() == 3) {
        if (tmp[0] != 0 && tmp[2] % 2 == 0) {
        int num = tmp[0] * 100 + tmp[1] * 10 + tmp[2];
            ans.push_back(num);
        }
        return;
    }
        for(int i=0;i<nums.size();i++){
        vector<int>ip(nums),op(tmp);
         if(i>0 && nums[i]==nums[i-1]) continue;
        // ip={1,2,4} op={}
        op.push_back(nums[i]);  
        ip.erase(ip.begin()+i);
        fun(ip,op,ans);
    }  
}
class Solution {
public:
    vector<int> findEvenNumbers(vector<int>& nums) {
        sort(nums.begin(),nums.end());
         vector<int> tmp;
         vector<int> ans;
        fun(nums,tmp,ans);
        sort(ans.begin(),ans.end());
        return ans;
    }   
};