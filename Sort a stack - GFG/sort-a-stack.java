// { Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}// } Driver Code Ends


/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		solve(s);
		return s;
	}
	public static void solve(Stack<Integer> s){
	    if(s.isEmpty()){
	        return;
	    }
	    int x = s.pop();
	    solve(s);
	    insert(s,x);
	}
	public static void insert(Stack<Integer> s,int x){
	    if(s.isEmpty() || s.peek()<x){
	        s.push(x);
	        return;
	    }
	    int a = s.pop();
	    insert(s,x);
	    s.push(a);
	    return;
	}
}