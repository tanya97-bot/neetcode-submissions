class Solution {
    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        if(edges.length != n-1) return false;
        for(int[] e: edges)
        {
            if(!dsu.union(e[0], e[1])) return false;
        }
        return true;

    }
    class DSU
    {
        int[] parent;
        int[] rank;
        public DSU(int n)
        {
            parent = new int[n];
            rank = new int[n];
            for(int i=0; i< n; i++)
            {
                parent[i] = i;
            }
        }

        public int find(int u)
        {
            if(parent[u] != u) parent[u] = find(parent[u]);
            return parent[u];
        }

        public boolean union(int u, int v)
        {
            int pu = find(u);
            int pv = find(v);

            if(pu == pv) return false;

            if(rank[pu] > rank[pv])
            {
                parent[pv] = pu;
            }
            else if(rank[pv] > rank[pu])
            {
                parent[pu] = pv;
            }
            else
            {
                rank[pu]++;
                parent[pv] = pu;
            }
            return true;
        }
    }
}
