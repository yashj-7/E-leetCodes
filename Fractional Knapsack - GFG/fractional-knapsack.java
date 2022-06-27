// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    class Manual{
        int value ;
        int weight;
        double profit;
        Manual(int value,int weight,double profit){
            this.value = value;
            this.weight = weight;
            this.profit = profit;
        }
    }
    class ManualComparator implements Comparator<Manual>{
        public int compare(Manual m1,Manual m2){
            if(m1.profit == m2.profit){
                return 0;
            }else if(m1.profit>m2.profit){
                return -1;
            }else{
                return 1;
            }
        }
    }
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        Manual[] vw = new Manual[arr.length];
        for(int i=0;i<arr.length;i++){
            vw[i] = new Manual(arr[i].value,arr[i].weight,(double)arr[i].value/(double)arr[i].weight);
        }
        Arrays.sort(vw,new ManualComparator());
        // for(int i=0;i<vw.length;i++){
        //     System.out.print(vw[i].profit+" ");
        // }
        double profit = 0;
        int weight = 0;
        for(int i=0;i<vw.length;i++){
            if(weight+vw[i].weight<=W){
                profit = profit+(double)vw[i].value;
                weight = weight + vw[i].weight;
            }else{
                
                double x = W-weight;
                x = x/((double)vw[i].weight);
                //System.out.println(x);
                profit = (double)profit + (double)((double)(W-weight)*(double)vw[i].profit);
                break;
            }
        }
        // int i=0;
        // while(weight+vw[i].weight>=W){
        //     profit = profit 
        // }
        return profit;
    }
}