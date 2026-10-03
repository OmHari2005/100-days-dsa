import java.util.*;

class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {

        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        Map<Integer, Integer> diagMap = new HashMap<>();
        Map<Integer, Integer> antiDiagMap = new HashMap<>();

        
        Set<Long> activeLamps = new HashSet<>();
        for (int[] lamp : lamps) {
            int r = lamp[0];
            int c = lamp[1];
            
            long code = (long) r * 1000000000L + c;

            
            if (activeLamps.add(code)) {
                rowMap.put(r, rowMap.getOrDefault(r, 0) + 1);
                colMap.put(c, colMap.getOrDefault(c, 0) + 1);
                diagMap.put(r - c, diagMap.getOrDefault(r - c, 0) + 1);
                antiDiagMap.put(r + c, antiDiagMap.getOrDefault(r + c, 0) + 1);
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int r = queries[i][0];
            int c = queries[i][1];

            if (rowMap.getOrDefault(r, 0) > 0 ||
                colMap.getOrDefault(c, 0) > 0 ||
                diagMap.getOrDefault(r - c, 0) > 0 ||
                antiDiagMap.getOrDefault(r + c, 0) > 0) {
                
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }

            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    int nr = r + dr;
                    int nc = c + dc;
                    
                    long code = (long) nr * 1000000000L + nc;

                    
                    if (activeLamps.remove(code)) {
                        decrement(rowMap, nr);
                        decrement(colMap, nc);
                        decrement(diagMap, nr - nc);
                        decrement(antiDiagMap, nr + nc);
                    }
                }
            }
        }

        return ans;
    }

    private void decrement(Map<Integer, Integer> map, int key) {
        int count = map.get(key);
        if (count == 1) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
        }
    }
}