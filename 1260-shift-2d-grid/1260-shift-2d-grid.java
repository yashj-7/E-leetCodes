class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                list.add(grid[i][j]);
            }
        }
        while(k>0){
            list.add(0,list.get(list.size()-1));
            list.remove(list.size()-1);
            k--;
        }
        int j=0;
        int i=0;
        List<Integer> temp = new ArrayList<>();
        while(i<list.size()){
            if(j==grid[0].length){
                result.add(new ArrayList(temp));
                j=0;
                temp.clear();
            }
            temp.add(list.get(i));
            i++;
            j++;
        }
        result.add(new ArrayList(temp));
        System.out.print(list);
        return result;
    }
}