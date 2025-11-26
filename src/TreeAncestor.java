class TreeAncestor {
    int LOG;
    int[][]up;
    public TreeAncestor(int n, int[] parent) {
        LOG = (int) Math.ceil(Math.log(n) / Math.log(2));
        up= new int[n][LOG];
        for (int i = 0; i < n; i++) {
            up[i][0]=parent[i];
        }
        for (int j = 1; j < LOG; j++) {
            for (int node = 0; node < n; node++) {
                int p = up[node][j - 1];

                if (p == -1) {
                    up[node][j] = -1;
                } else {
                    up[node][j] = up[p][j - 1];
                }
            }
        }


    }

    public int getKthAncestor(int node, int k) {
        if(k>LOG) return -1;
        if(node>=up.length) return -1;
        for (int j = 0; j <= LOG; j++) {
            if ((k & (1 << j)) != 0) {
                int p = up[node][j];
                if (p == -1) return -1;
                node = p;
            }
        }
        return node;
    }

    public static void main(String[] args) {


        TreeAncestor treeAncestor= new TreeAncestor(2,new int[]{-1, 0});
        System.out.println(treeAncestor.getKthAncestor(1,2));

    }
}
