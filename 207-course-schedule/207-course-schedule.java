class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0){
            return true;
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        int[] dep = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int[] a = prerequisites[i];
            list.get(a[1]).add(a[0]);
            dep[a[0]]++;
        }
        System.out.println(list);
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int j=0;j<numCourses;j++){
            if(dep[j]==0){
                q.offer(j);
            }
        }
            while(q.isEmpty()==false){
                int x = q.poll();
                count++;
                for(int a:list.get(x)){
                    dep[a]--;
                    if(dep[a]==0){
                        q.offer(a);
                    }
                }
            } 
        System.out.println(count);
        return count==numCourses;
    }
}