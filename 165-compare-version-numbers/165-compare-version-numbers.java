class Solution {
    public int compareVersion(String version1, String version2) {
       String[] v1 = version1.split("[.]");
        String[] v2 = version2.split("[.]");
        int i =0;
        int j=0;
        while(i<v1.length && j<v2.length){
            int x = Integer.parseInt(v1[i]);
            int y = Integer.parseInt(v2[i]);
            if(x<y){
                return -1;
            }else if(x>y){
                return 1;
            }else{
                if(i==v1.length-1 && j==v2.length-1){
                    return 0;
                }
            }
            i++;
            j++;
        }
        if(i==v1.length && j<v2.length){
            while(j<v2.length){
                int x =0;
            int y = Integer.parseInt(v2[j]);
            if(x<y){
                return -1;
            }else if(x==y){
                if(j==v2.length-1){
                    return 0;
                }
            }
            j++;   
            }
        }
        if(i!=v1.length && j==v2.length){
            while(i<v1.length){
                int x =Integer.parseInt(v1[i]);
            int y = 0;
            if(x>y){
                return 1;
            }else if(x==y){
                if(i==v1.length-1){
                    return 0;
                }
            }
            i++;   
            }
        }
       return 1;
    }
}