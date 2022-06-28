// { Driver Code Starts
#include<bits/stdc++.h> 
using namespace std; 

 // } Driver Code Ends
class Solution
{
public:
    vector<int> candyStore(int candies[], int n, int K)
    {
         sort(candies,candies+n);
       int i=0;int j=n-1;
       int mxcost=0;
       int mncost=0;
       
       while(i<=j)
       {
          
           mncost +=candies[i];
            i++;
           j=j-K;
           
       }
       
       i=n-1;j=0;
      while(j<=i)
      {
          j=j+K;
          mxcost +=candies[i];
          i--;
          
      }
      return {mncost,mxcost};
   }
};

// { Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int N, K;
        cin >> N >> K;
        int candies[N];

        for (int i = 0; i < N; i++)
        {
            cin >> candies[i];
        }

        Solution ob;
        vector<int> cost = ob.candyStore(candies, N, K);
        cout << cost[0] << " " << cost[1] << endl;
    }
    return 0;
}  // } Driver Code Ends