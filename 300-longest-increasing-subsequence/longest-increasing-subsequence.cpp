class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int>temp;
        for(auto a:nums){
            if(temp.size()==0 ||a>temp.back()){
                temp.push_back(a);
            }
            else{
                for(int j=0;j<temp.size();j++){
                    if(temp[j]>=a){
                        temp[j]=a ;
                    break;
                    }
                }
            }
        }
        for(auto a:temp) cout<<a<<" ";
        return temp.size();
    }
};