class Solution {
public:
    bool uniformArray(vector<int>& nums) {
        int m=1e9;
        int f=0;
        for(auto a:nums){
            if(a%2){
                m=min(m,a);
                f=1;
            }
        }

        if(!f) return 1;

        for(auto a:nums){
            if(a%2==0 && m>a) return 0;
        }

        return 1;
    }
};