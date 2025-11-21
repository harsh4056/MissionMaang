import java.util.*;

public class MergeSortTreeInversions {

    static class MergeSortTree {
        ArrayList<Integer>[] tree;
        int n;

        MergeSortTree(int[] arr) {
            n = arr.length;
            tree = new ArrayList[4 * n];
            build(1, 0, n - 1, arr);
        }

        void build(int node, int l, int r, int[] arr) {
            tree[node] = new ArrayList<>();
            if (l == r) {
                tree[node].add(arr[l]);
                return;
            }
            int mid = (l + r) >> 1;

            int left = node << 1;
            int right = (node << 1) | 1;

            build(left, l, mid, arr);
            build(right, mid + 1, r, arr);

            merge(tree[left], tree[right], tree[node]);
        }

        void merge(List<Integer> A, List<Integer> B, List<Integer> C) {
            int i = 0, j = 0;
            while (i < A.size() && j < B.size()) {
                if (A.get(i) <= B.get(j)) C.add(A.get(i++));
                else C.add(B.get(j++));
            }
            while (i < A.size()) C.add(A.get(i++));
            while (j < B.size()) C.add(B.get(j++));
        }

        int upperBound(List<Integer> arr, int x) {
            int lo = 0, hi = arr.size();
            while (lo < hi) {
                int mid = (lo + hi) >> 1;
                if (arr.get(mid) <= x) lo = mid + 1;
                else hi = mid;
            }
            return lo;
        }

        // count elements > x in [ql, qr]
        int queryGreater(int node, int l, int r, int ql, int qr, int x) {
            if (qr < l || r < ql) return 0;
            if (ql <= l && r <= qr) {
                List<Integer> list = tree[node];
                int idx = upperBound(list, x);
                return list.size() - idx;
            }

            int mid = (l + r) >> 1;
            int left = node << 1;
            int right = (node << 1) | 1;

            return queryGreater(left, l, mid, ql, qr, x)
                    + queryGreater(right, mid + 1, r, ql, qr, x);
        }
    }

    // SINGLE METHOD YOU ASKED FOR
    public static long[] countInversionQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        MergeSortTree mst = new MergeSortTree(arr);

        long[] ans = new long[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {
            int L = queries[qi][0];
            int R = queries[qi][1];
            long inv = 0;

            for (int i = L; i <= R; i++) {
                inv += mst.queryGreater(1, 0, n - 1, i + 1, R, arr[i]);
            }
            ans[qi] = inv;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};

        int[][] queries = {
                {0, 4},
                {1, 3},
                {2, 4}
        };

        long[] res = countInversionQueries(arr, queries);
        for (long x : res) System.out.println(x);
    }
}
