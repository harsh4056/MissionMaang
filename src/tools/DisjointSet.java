package tools;

public class DisjointSet {

    int[]parent;

    int[]size;

    public DisjointSet(int n) {
        parent= new int[n];
        size= new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
            size[i] = 0;
        }
    }
    public int findUltimateParent(int node){
        if(parent[node]==node){
            return node;
        }
        return parent[node]=findUltimateParent(node);
    }

    public void unionBySize(int u,int v){
        int pu = findUltimateParent(u);
        int pv = findUltimateParent(v);
        if (pu == pv) return;
        if (size[pu] >= size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }

    }
}
