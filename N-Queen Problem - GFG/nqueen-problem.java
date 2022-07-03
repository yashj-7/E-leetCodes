// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[][] placed = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(placed[i],-1);
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0;i<n;i++){
            placed[0][i] = 1;
            temp.add(i+1);
            solve(list,temp,1,n,placed);
            placed[0][i] = -1;
            temp.remove(temp.size()-1);
        }
        return list;
    }
    public static void solve(ArrayList<ArrayList<Integer>> list ,ArrayList<Integer> temp, int i,int n,int[][] placed){
        //System.out.println(temp);
        if(i==n){
            //System.out.println("working");
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int j=0;j<n;j++){
            // if(j-1>=0 && placed[i-1][j-1]==-1 && placed[i-1][j]==-1 && j+1<n && placed[i-1][j+1]==-1){
            //     placed[i][j]=1;
            //     temp.add(j+1);
            //     solve(list,temp,i+1,n,placed);
            //     placed[i][j]=-1;
            //     temp.remove(temp.size()-1);
            // }else if(j==0 && placed[i-1][j]!=-1 && j+1<n && placed[i-1][j+1]!=-1){
            //     placed[i][j] =1;
            //     temp.add(j+1);
            //     solve(list,temp,i+1,n,placed);
            //     placed[i][j]=-1;
            //     temp.remove(temp.size()-1);
            // }else if(j==n-1 && placed[i-1][j]!=-1 && j-1>=0 && placed[i-1][j-1]!=-1){
            //     placed[i][j] = 1;
            //     temp.add(j+1);
            //     solve(list,temp,i+1,n,placed);
            //     placed[i][j] = -1;
            //     temp.remove(temp.size()-1);
            // }
            if(j==0 && j<n){
                boolean flag = true;
                int k =i;
                int x = j;
                while(k>0){
                    if(placed[k-1][x]==1){
                        flag=false;
                    }
                    k--;
                }
                k=i;
                x=j;
                while(k>0 && x+1<n){
                    if(placed[k-1][x+1]==1){
                        flag=false;
                    }
                    k--;
                    x++;
                }
                
                if(flag==true){
                    placed[i][j]=1;
                    temp.add(j+1);
                    solve(list,temp,i+1,n,placed);
                    placed[i][j]=-1;
                    temp.remove(temp.size()-1);
                }
            }else if(j>0 && j<n-1){
                
                boolean flag = true;
                int k =i;
                int x = j;
                
                while(k>0){
                    if(placed[k-1][x]==1){
                        flag=false;
                    }
                    k--;
                }
                k=i;
                x=j;
                while(k>0 && x+1<n){
                    if(placed[k-1][x+1]==1){
                        flag=false;
                    }
                    k--;
                    x++;
                }
                k=i;
                x=j;
                while(k>0 && x-1>=0){
                    if(placed[k-1][x-1]==1){
                        flag=false;
                    }
                    k--;
                    x--;
                }
                
                
                if(flag==true){
                    placed[i][j]=1;
                    temp.add(j+1);
                    solve(list,temp,i+1,n,placed);
                    placed[i][j]=-1;
                    temp.remove(temp.size()-1);
                }
            }else if(j==n-1 && j>0){
                
                boolean flag = true;
                int k =i;
                int x = j;
                while(k>0){
                    if(placed[k-1][x]==1){
                        flag=false;
                    }
                    k--;
                }
                // while(k>0 && x+1<n){
                //     if(placed[k-1][x+1]==1){
                //         flag=false;
                //     }
                //     k--;
                //     x++;
                // }
                k=i;
                x=j;
                while(k>0 && x-1>=0){
                    if(placed[k-1][x-1]==1){
                        flag=false;
                    }
                    k--;
                    x--;
                }
                
                
                if(flag == true){
                    placed[i][j]=1;
                    temp.add(j+1);
                    solve(list,temp,i+1,n,placed);
                    placed[i][j]=-1;
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
}