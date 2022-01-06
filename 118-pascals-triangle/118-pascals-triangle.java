class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listM = new ArrayList<List<Integer>>();
        for(int i=1;i<=numRows; i++){
            if(i==1){
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                listM.add(list);
            }else{
                int j=i;
                 List<Integer> list = new ArrayList<Integer>();
                while(j>0){
                   
                    if(j==1 || j==i){
                        list.add(1);
                    }else{
                        List<Integer> list1 = new ArrayList<Integer>();
                        list1 = listM.get(i-2);
                        list.add(list1.get(j-2)+list1.get(j-1));
                    }
                    j--;
                }
                listM.add(list);
            }
        }
        return listM;
    }
}