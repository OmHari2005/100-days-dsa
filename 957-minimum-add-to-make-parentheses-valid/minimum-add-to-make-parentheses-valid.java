class Solution {
    public int minAddToMakeValid(String s) {
        int x=0;
        int y=0;
        int ans =0;
        for( char i : s.toCharArray()){
            if(i=='(')
            x++;
            else y++;
            if(y>x){
             ans++;
             x++;
            }
        }
        return ans+ Math.abs(x-y);
    }
}



/*class Solution {
public:
    int minAddToMakeValid(string s) {
        int x=0,y=0,ans=0;;
        for(auto a:s){
            if(a=='(') x++;
            else y++;

            if(y>x){ ans++; x++;}
        }

        return ans+abs(x-y);
    }
};
*/