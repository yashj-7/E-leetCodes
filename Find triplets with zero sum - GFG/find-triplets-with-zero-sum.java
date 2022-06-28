// { Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int arr[] , int n)
    {
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            int j=i+1;
            int k=arr.length-1;
            int sum = 0-arr[i];
            while(j<k){
                if(arr[j]+arr[k]==sum){
                    return true;
                }else if(arr[j]+arr[k]>sum){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return false;
    }
}