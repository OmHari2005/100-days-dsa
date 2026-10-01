class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer>ds= new ArrayList<>();
        int[] cand={1,2,3,4,5,6,7,8,9};
        fun(0,k,n,cand,ds,ans);
        return ans;
    }
void fun(int i ,int k,int n,int cand[],List<Integer>ds,List<List<Integer>>ans){
     
       if(n==0 && k==0  ){
        ans.add(new ArrayList<>(ds));
        return;
       }
       if(k<0 || n<0 || i>=cand.length){
        return;
       }
       if(cand[i]<=n){
       ds.add(cand[i]);
       fun(i+1,k-1,n-cand[i],cand,ds,ans);
        ds.remove(ds.size()-1);
       }
       fun(i+1,k,n,cand,ds,ans);
    }   
}

