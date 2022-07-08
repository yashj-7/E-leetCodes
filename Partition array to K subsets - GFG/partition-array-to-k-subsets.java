// { Driver Code Starts
import java.util.*;

class Partition_Arr_To_K_Subsets
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			int k = sc.nextInt();
			Solution g = new Solution();
			if(g.isKPartitionPossible(a,n,k)==true)
				System.out.println(1);
			else 
				System.out.println(0);
			
		t--;
		}
	}
}// } Driver Code Ends


/*You are required to complete this method */

class Solution
{
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
	    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	    if(k==1){
	        return true;
	    }
	    if(k==n){
	        boolean x = true;
	        int y = a[0];
	        for(int i=1;i<n;i++){
	            if(a[i]!=a[0]){
	                return false;
	            }
	        }
	        return x;
	    }
	    if(k>n){
	        return false;
	    }
	    for(int i=0;i<k;i++){
	        list.add(new ArrayList<>());
	    }
	    int sum = 0;
	    for(int i=0;i<a.length;i++){
	        sum = sum+a[i];
	    }
	    if(sum%k!=0){
	        return false;
	    }
	    //System.out.println("working");
	    sum = sum/k;
	    boolean[] res= new boolean[1];
	    res[0] = false;
	     solve(a,0,k,0,list,sum,res);
	    return res[0];
	    
    }
    public static void solve(int[] a,int ssf,int k,int i,ArrayList<ArrayList<Integer>> list,int sum,boolean[] res){
        //System.out.println(i);
        if(i==a.length){
            // System.out.println(ssf);
            // System.out.println(list);
            if(ssf!=k){
                return;
            }
            int s = 0;
            for(int x=0;x<list.size();x++){
                for(int j=0;j<list.get(x).size();j++){
                    s = s+list.get(x).get(j);
                }
                if(s!=sum){
                    return;
                }
                s=0;
            }
            //System.out.println(s);
            res[0] = true;
            return;
        }
        // boolean b1 = false;
        // boolean b2 = false;
        for(int j=0;j<list.size();j++){
            if(list.get(j).size()>0){
                list.get(j).add(a[i]);
                solve(a,ssf,k,i+1,list,sum,res);
                list.get(j).remove(list.get(j).size()-1);
            }else{
                list.get(j).add(a[i]);
                solve(a,ssf+1,k,i+1,list,sum,res);
                list.get(j).remove(list.get(j).size()-1);
                break;
            }
        }
        //return b1||b2;
    }
    
}
