// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
// Function to return minimum number of jumps to end of array

class Solution{
  public:
    int minJumps(int arr[], int n){
        // Your code here
        int p;
        int i = n-1;
        int curr;
        int count = 0;
        while(i >0)
        {
            for(int j = 0;i-j>=0 ;j++)
            {
                if(arr[i-j] >= j)
                {
                    p = i-j;
                }
            }
            if(p==i)
            {
                return -1;
            }
            count++;
            i = p;
        }
        return count;
        
    }
};


// { Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n,i,j;
        cin>>n;
        int arr[n];
        for(int i=0; i<n; i++)
            cin>>arr[i];
        Solution obj;
        cout<<obj.minJumps(arr, n)<<endl;
    }
    return 0;
}
  // } Driver Code Ends