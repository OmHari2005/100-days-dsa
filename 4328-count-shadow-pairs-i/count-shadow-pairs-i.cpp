class Solution { 
public: 
    long long shadowPairs(vector<int>& nums) { 
        long long ans=0; 
        vector<int>s1; 
 
        for(int i=0;i<nums.size();i++){ 
            if(s1.size()==0){ 
                s1.push_back(nums[i]); 
                continue; 
            } 
 
            while(s1.size()>0 && s1.back()>nums[i]) 
                s1.pop_back(); 
 
            s1.push_back(nums[i]); 
 
            int j=lower_bound(s1.begin(),s1.end(),nums[i])-s1.begin(); 
 
            ans+=j; 
        } 
 
        return ans; 
    } 
};