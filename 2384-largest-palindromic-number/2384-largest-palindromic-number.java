class Solution {
    public String largestPalindromic(String num) {
        int[] f = new int[10];
        for(int i=0;i<num.length();i++){
            f[Character.getNumericValue(num.charAt(i))]++;
        }
        boolean flag=false;
        StringBuilder pre = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        StringBuilder post = new StringBuilder();
        for(int i=9;i>=0;i--){
            if(f[i]>0 && f[i]%2!=0 && flag==false){
                flag = true;
                mid.append(String.valueOf(i));
            }
            if(i==0 && pre.length()==0){
                if(f[i]>0 && mid.length()==0){
                    mid.append(Character.toString(num.charAt(i)));
                }
                return mid.toString();
            }
            for(int j=0;j<f[i]/2;j++){
                pre.append(String.valueOf(i));
                post.insert(0,String.valueOf(i));
            }
        }
        pre.append(mid);
        pre.append(post);
        return pre.toString();
    }
}