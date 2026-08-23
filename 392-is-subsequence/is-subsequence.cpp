bool fun(int i,int j,string &s,string &t){
    if(i>=s.size()) return true;  // i ko traverse kia size tak s ke
    if(j>=t.size()) return false;// j ko traverse kia size tak t ke
    
    if(s[i] == t[j]){    // jab condition true hui 
        return fun(i+1,j+1,s,t); // to function return ho gya aur dono ma plus one cll kia taki next pe jaya
    }
    return fun(i,j+1,s,t); // aur agr i ka elemnt us place pe nhi mila to j ko iterate krenga jab tak nhi mila
}
class Solution {
public:
    bool isSubsequence(string s, string t) {
        return fun(0,0,s,t);  // call krdia function ko
    }
};