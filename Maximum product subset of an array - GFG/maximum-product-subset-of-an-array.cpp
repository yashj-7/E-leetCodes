// { Driver Code Starts
/* Driver program to test above function */

#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function Template for C++
class Solution{
    public:
    long long int findMaxProduct(vector<int>&arr, int n){
        int maxneg = INT_MIN;
   bool hasOne = false;
   bool hasZero = false;
   long prod = 1;
   long mod = (long)1e9+7;
   
   for(int i=0; i<n; i++){
       if(arr[i] != 0)
           prod = (prod * arr[i])%mod;
       else
           hasZero = true;
       if(arr[i] == 1)
           hasOne = true;
       if(arr[i] < 0)
           maxneg = max(maxneg, arr[i]);
   }
   if(prod < 0)
       prod /= maxneg;
       
   if(prod == 1 && !hasOne && hasZero)
       return 0;
   if(prod == 1 && !hasOne && !hasZero)
       return maxneg;
       
   return prod%mod;
    }
};



// { Driver Code Starts.
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
	    int n;
	    cin >> n;
	    vector<int>arr(n);
	    for(int i = 0 ; i < n; i++){
	        cin >> arr[i];
	    }
	    Solution ob;
	    long long int ans = ob.findMaxProduct(arr, n);
	    cout << ans<<endl;
	}
	return 0;
}
  // } Driver Code Ends