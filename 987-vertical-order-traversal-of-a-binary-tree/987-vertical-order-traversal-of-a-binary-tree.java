/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    class Triplet{
        TreeNode n;
        int col;
        int row;
        Triplet(TreeNode n,int col,int row){
            this.n = n;
            this.col = col;
            this.row = row;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap();
        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(root,0,0));
        while(q.isEmpty()==false){
            Triplet temp = q.poll();
            if(temp.n.left!=null){
                q.offer(new Triplet(temp.n.left,temp.col-1,temp.row+1));
            }
            if(temp.n.right!=null){
                q.offer(new Triplet(temp.n.right,temp.col+1,temp.row+1));
            }
            if(map.containsKey(temp.col)){
                TreeMap<Integer,PriorityQueue<Integer>> mp = map.get(temp.col);
                if(mp.containsKey(temp.row)){
                    mp.get(temp.row).add(temp.n.val);
                }else{
                    PriorityQueue<Integer> p = new PriorityQueue<Integer>();
                    p.add(temp.n.val);
                    mp.put(temp.row,p);
                }
            }else{
                PriorityQueue<Integer> p = new PriorityQueue<Integer>();
                p.add(temp.n.val);
                TreeMap<Integer,PriorityQueue<Integer>> m = new TreeMap<>();
                m.put(temp.row,p);
                map.put(temp.col,m);
            }
        }
        while(map.size()>0){
            int key = map.firstKey();
            TreeMap<Integer,PriorityQueue<Integer>> mp = new TreeMap<>();
            mp = map.get(key);
            ArrayList<Integer> list2 = new ArrayList<>();
            while(mp.size()>0){
                int k = mp.firstKey();
                PriorityQueue<Integer> prq = mp.get(k);
                while(prq.size()>0){
                    list2.add(prq.poll());
                }
                mp.remove(k);
            }
            list.add(list2);
            map.remove(key);
        }
        
        return list;
    }
}