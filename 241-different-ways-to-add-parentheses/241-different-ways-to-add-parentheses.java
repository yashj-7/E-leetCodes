class Solution {
    public List<Integer> diffWaysToCompute(String s) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='-'||c=='+'||c=='*'){
                List<Integer> part1 = diffWaysToCompute(s.substring(0,i));
            List<Integer> part2 = diffWaysToCompute(s.substring(i+1,s.length()));
            for(int a:part1){
                for(int b:part2){
                    if(c=='-'){
                        list.add(a-b);
                    }else if(c=='+'){
                        list.add(a+b);
                    }else if(c=='*'){
                        list.add(a*b);
                    }
                }
            }   
            }
        }
        if(list.size()==0){
            list.add(Integer.parseInt(s));
        }
        return list;
    }
    
    //this hada problm
    // public static int solve(String s,ArrayList<Integer> list){
    //     //System.out.println(s);
    //     if(s.length()==1){
    //         return Character.getNumericValue(s.charAt(0));
    //     }
    //     int ans = 0;
    //     for(int i=1;i<s.length();i=i+2){
    //         if(s.charAt(i)=='-' || s.charAt(i)=='+' || s.charAt(i)=='*'){
    //             int ans1 = solve(s.substring(0,i),list);
    //             int ans2= solve(s.substring(i+1,s.length()),list);
    //             if(s.charAt(i)=='-'){
    //                 ans=ans1-ans2;
    //             }else if(s.charAt(i)=='+'){
    //                 ans=ans1+ans2;
    //             }else if(s.charAt(i)=='*'){
    //                 ans=ans1*ans2;
    //             }
    //         }
    //         if(s.length()==7){
    //             list.add(ans);
    //         }
    //     }
    //     return ans;
    // }
}