import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        // Build original tree
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            tree.get(parent[i]).add(i);
        }

        int[] newParent = parent.clone();

        // Stack for each character
        List<Deque<Integer>> stacks = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            stacks.add(new ArrayDeque<>());
        }

        // Find closest same-character ancestor
        dfs(0, s, tree, stacks, newParent);

        // Build final tree
        List<List<Integer>> finalTree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            finalTree.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            finalTree.get(newParent[i]).add(i);
        }

        // Calculate subtree sizes iteratively
        return getSubtreeSizes(finalTree, newParent, n);
    }

    void dfs(
        int node,
        String s,
        List<List<Integer>> tree,
        List<Deque<Integer>> stacks,
        int[] newParent
    ) {
        char ch = s.charAt(node);
        Deque<Integer> st = stacks.get(ch - 'a');

        // Closest ancestor with same character
        if (!st.isEmpty()) {
            newParent[node] = st.peek();
        }

        st.push(node);

        for (int child : tree.get(node)) {
            dfs(child, s, tree, stacks, newParent);
        }

        st.pop();
    }

    int[] getSubtreeSizes(
        List<List<Integer>> tree,
        int[] newParent,
        int n
    ) {
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        // BFS order: parent comes before child
        List<Integer> order = new ArrayList<>();
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);

            for (int child : tree.get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.add(child);
                }
            }
        }

        // Process from last node to root
        for (int i = order.size() - 1; i >= 0; i--) {
            int node = order.get(i);

            if (node != 0) {
                ans[newParent[node]] += ans[node];
            }
        }

        return ans;
    }
}