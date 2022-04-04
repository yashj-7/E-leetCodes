// { Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Arrays.fill(vis,0);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        // for(int i=0;i<V;i++){
        //     if(vis[i]==0){
        //         vis[i]=1;
        //         bfs(i,vis,adj,ans);
        //     }
        // }
        bfs(0,vis,adj,ans);
        return ans;
    }
    public static void bfs(int i,int[] vis,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        
        while(q.isEmpty()==false){
            int x = q.poll();
            ans.add(x);
            for(int j=0;j<adj.get(x).size();j++){
                if(vis[adj.get(x).get(j)]==0){
                   vis[adj.get(x).get(j)]=1; 
                    q.add(adj.get(x).get(j));
                }
            }
    }
}
}