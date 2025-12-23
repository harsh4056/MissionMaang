import java.util.*;

public class FindAllPeopleWithSecret {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings,(a,b)-> a[2]-b[2]);
        UnionFind uf= new UnionFind(n);
        uf.size[0]=2;
        uf.parent[firstPerson]=0;


        for (int i = 0; i < meetings.length; i++) {
            int[] meeting = meetings[i];
            int u = meeting[0];
            int v = meeting[1];
            int t = meeting[2];
            uf.unionBySize(u,v);

        }
        List<Integer> list= new ArrayList<>();
        for (int i = 0; i < uf.parent.length; i++) {
            uf.findParent(i);
        }
        for (int i = 0; i < uf.parent.length; i++) {
            if(uf.parent[i]==0){
                list.add(i);
            }

        }
        return list;

    }



    class UnionFind {
        int[] parent;
        int[] size;

        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findParent(int u) {
            if (parent[u] == u) return u;
            return parent[u] = findParent(parent[u]);
        }

        void unionBySize(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);

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



    public static void main(String[] args) {
        FindAllPeopleWithSecret soln = new FindAllPeopleWithSecret();
        int n = 12;
        int[][] meetings = {
                {10, 8, 6},
                {9, 5, 11},
                {0, 5, 18},
                {4, 5, 13},
                {11, 6, 17},
                {0, 11, 10},
                {10, 11, 7},
                {5, 8, 3},
                {7, 6, 16},
                {3, 6, 10},
                {3, 11, 1},
                {8, 3, 2},
                {5, 0, 7},
                {3, 8, 20},
                {11, 0, 20},
                {8, 3, 4},
                {1, 9, 4},
                {10, 7, 11},
                {8, 10, 18}
        };
        int firstPerson = 9;

        System.out.println(soln.findAllPeople(n, meetings, firstPerson));
        // Expected: [0, 1, 3, 5, 8, 9, 10, 11]

        // Test case 1
        int n1 = 6;
        int[][] meetings1 = {
                {1, 2, 5},
                {2, 3, 8},
                {1, 5, 10}
        };
        int firstPerson1 = 1;
        System.out.println(soln.findAllPeople(n1, meetings1, firstPerson1));
        // Expected: [0, 1, 2, 3, 5]

        // Test case 2
        int n2 = 4;
        int[][] meetings2 = {
                {3, 1, 3},
                {1, 2, 2},
                {0, 3, 3}
        };
        int firstPerson2 = 3;
        System.out.println(soln.findAllPeople(n2, meetings2, firstPerson2));
        // Expected: [0, 1, 3]

        // Test case 3
        int n3 = 5;
        int[][] meetings3 = {
                {0, 2, 1},
                {1, 3, 1},
                {4, 1, 1}
        };
        int firstPerson3 = 1;
        System.out.println(soln.findAllPeople(n3, meetings3, firstPerson3));
        // Expected: [0, 1, 2, 3, 4]
    }

}
