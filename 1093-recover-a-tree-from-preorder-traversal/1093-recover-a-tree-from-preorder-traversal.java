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
    public TreeNode recoverFromPreorder(String s) {
        HashMap<Integer, TreeNode> depthNodes= new  HashMap<Integer, TreeNode>();
        int n= s.length();
        TreeNode root=null;
        int i=0;
        while(i<n)
        {
            // get depth
            int start=i;
            while(i<n && s.charAt(i)=='-')
            {
                i++;
            }
            int dep=i-start;

            //get value
            int val=0;
            while(i<n && Character.isDigit(s.charAt(i)))
            {
                val= val*10+(s.charAt(i)-'0');
                i++;
            }

            TreeNode newNode= new TreeNode(val);
            depthNodes.put(dep,newNode);
            if(dep==0)
            {
                root=newNode; //save rootnode
            }
            //attach current node to its parent at depth-1
            if(depthNodes.containsKey(dep-1))
            {
                if(depthNodes.get(dep-1).left==null)
                {
                    depthNodes.get(dep-1).left=newNode;
                }
                else if(depthNodes.get(dep-1).right==null)
                {
                    depthNodes.get(dep-1).right=newNode;
                }

                // children will be filled as left first then right
            }
        }
        return root;
    }
}