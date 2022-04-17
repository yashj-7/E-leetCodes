// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    
    public class Com implements Comparator<Job>{
    public int compare(Job a, Job b){
        if(a.profit>b.profit){
            return -1;
        }else if(a.profit == b.profit){
            return 0;
        }else {
            return 1;
        }
        
    }
}
    
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr,new Com());
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i].profit+" ");
        // }
        int[] flag = new int[101];
        Arrays.fill(flag,-1);
        //System.out.println();
        //int time = 0;
        int profit = 0;
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(flag[arr[i].deadline]==-1){
                count++;
                profit = profit+arr[i].profit;
                flag[arr[i].deadline] = 1;
            }else{
                int j =arr[i].deadline;
                while(flag[j]!=-1){
                    j--;
                }
                if(j>0){
                    count++;
                    profit=profit+arr[i].profit;
                    flag[j] = 1;
                }
            }
        }
        int[] ans = new int[2];
        ans[0] = count;
        ans[1] = profit;
        return ans;
    }
}