int dp[400];

int fun(int i,vector<int>&days,vector<int>&cost){
    if(i>=days.size()) return 0;

    int curr=days[i];

    if(dp[i]!=-1) return dp[i];

    int one=cost[0]+fun(i+1,days,cost);

    int id1=days.size(),id2=days.size();

    int seven,thirty;

    for(int j=i+1;j<days.size();j++){
        if(days[j]>=curr+7){
            id1=j;
            break;
        }
    }

    for(int j=i+1;j<days.size();j++){
        if(days[j]>=curr+30){
            id2=j;
            break;
        }
    }

    seven=cost[1]+fun(id1,days,cost);
    thirty=cost[2]+fun(id2,days,cost);

    return dp[i]=min({one,seven,thirty});
}


class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        memset(dp,-1,sizeof(dp));
        return fun(0,days,costs);
    }
};