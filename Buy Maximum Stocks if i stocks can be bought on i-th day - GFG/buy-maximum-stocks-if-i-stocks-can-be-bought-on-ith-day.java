// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    static class Pair{
        int price;
        int day;
        Pair(int price,int day){
            this.price = price;
            this.day = day;
        }
    }
    static class ManualComp implements Comparator<Pair>{
        public int compare(Pair p1,Pair p2){
            if(p1.price==p2.price){
                if(p1.day>p2.day){
                    return 1;
                }else{
                    return -1;
                }
            }else if(p1.price>p2.price){
                return 1;
            }else{
                return -1;
            }
        }
    }
    public static int buyMaximumProducts(int n, int k, int[] price) {
        Pair[] arr = new Pair[price.length];
        for(int i=0;i<price.length;i++){
            arr[i] = new Pair(price[i],i+1);
        }
        Arrays.sort(arr,new ManualComp());
        int ans = 0;
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i].price+" "+arr[i].day+" ");
        // }
        for(int i=0;i<arr.length;i++){
            if(k==0){
                break;
            }
            Pair p = arr[i];
            ans = ans+Math.min(p.day,k/p.price);
            int x = Math.min(p.day,k/p.price);
             //System.out.println(k);
            k = k - (x*p.price);
           // System.out.println(ans);
        }
        return ans;
    }
}
        
