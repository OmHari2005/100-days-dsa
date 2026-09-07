/*class Solution {
    private void find Combinations(int ind,int[]arr,int target,List<List<Integer>>ans,List<Integer>ds){
        if(ind==arr.length){
            ans.add(new ArrayList<>(ds));
        }
        return;
    }
    for

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
    }
}*/
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    private void findCombinations(int idx, int[] arr, int target,
                                  List<Integer> ds, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = idx; i < arr.length; i++) {

            if (i > idx && arr[i] == arr[i - 1]) {
                continue;
            }

            if (arr[i] > target) {
                break;
            }

            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ds, ans);
            ds.remove(ds.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> res = sol.combinationSum2(candidates, target);
        System.out.println(res);
    }
}