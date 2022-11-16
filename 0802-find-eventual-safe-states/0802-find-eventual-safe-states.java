class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] vis = new int[graph.length];
        int[] pathVis = new int[graph.length];
        int[] check = new int[graph.length];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(vis[i]==0){
                dfsCycleCheck(i,graph,vis,pathVis,check);
            }
        }
        for(int i=0;i<check.length;i++){
            if(check[i]==1){
                list.add(i);
            }
        }
        return list;
    }
    public static boolean dfsCycleCheck(int i,int[][] graph,int[] vis,int[] pathVis,int[] check){
        vis[i]=1;
        pathVis[i]=1;
        check[i]=0;
        for(int j=0;j<graph[i].length;j++){
            if(vis[graph[i][j]]==0){
                if(dfsCycleCheck(graph[i][j],graph,vis,pathVis,check)){
                    check[i]=0;
                    return true;
                }
            }else if(pathVis[graph[i][j]]==1){
                check[i]=0;
                return true;
            }
        }
        check[i]=1;
        pathVis[i]=0;
        return false;
    }
}