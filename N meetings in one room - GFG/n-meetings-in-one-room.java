// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution 
{   
    public static class ManualCom implements Comparator<Meeting>{
        public int compare(Meeting a,Meeting b){
            if(a.end<b.end){
                return -1;
            }else if(a.end == b.end){
                return 0;
            }else if(a.end>b.end){
                return 1;
            }
            return 1;
        }
    }
    public static class Meeting{
        int start;
        int end;
        Meeting(int s,int e){
            this.start = s;
            this.end = e;
        }
    }
    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<Meeting> list1 = new ArrayList<Meeting>();
        for(int i=0;i<n;i++){
            list1.add(new Meeting(start[i],end[i]));
        }
        Collections.sort(list1,new ManualCom());
        int count =0;
        int limit = 0;
        for(int i=0;i<n;i++){
            if(i==0){
                count = 1;
                limit = list1.get(i).end;
            }else{
                if(list1.get(i).start>limit){
                    count++;
                    limit = list1.get(i).end;
                }
            }
        }
        return count;
    }
}
