class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int x = prerequisites[i][0];
            int y = prerequisites[i][1];
            list.get(y).add(x);
        }
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            ArrayList<Integer> tmp = list.get(i);
            for(int j=0;j<tmp.size();j++){
                indegree[tmp.get(j)]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int[] ans = new int[numCourses];
        ArrayList<Integer> tem = new ArrayList<>();
        int j=0;
        while(q.isEmpty()==false){
            int x = q.poll();
            tem.add(x);
            for(int i=0;i<list.get(x).size();i++){
                indegree[list.get(x).get(i)]--;
                if(indegree[list.get(x).get(i)]==0){
                    q.offer(list.get(x).get(i));
                }
            }
            j++;
        }
        if(tem.size()==0){
            int[] res = {};
            return res;
        }
        if(tem.size()<numCourses){
            int[] res = new int[0];
            return res;
        }
        for(int i=0;i<ans.length;i++){
            ans[i]=tem.get(i);
        }
        return ans;
    }
}