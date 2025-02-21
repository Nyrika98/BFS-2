// 993. Cousins in Binary Tree - https://leetcode.com/problems/cousins-in-binary-tree/
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did it run on Leetcode? : Yes
// Any problems? : No

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
    TreeNode xParent, yParent;
    boolean xFound, yFound;
    int xLevel, yLevel;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null || root.val==x || root.val==y)
            return false;
        
        dfs(root, 0, null, x, y);
        return xLevel == yLevel && xParent != yParent;
    }
    
    private void dfs(TreeNode root, int level, TreeNode parent, int x, int y){
        // base
        if(root==null) return;
        if(xFound && yFound) return;
        
        // logic
        if(root.val == x){
            xLevel = level;
            xFound = true;
            xParent = parent;
        }
        
        else if(root.val == y){
            yLevel = level;
            yFound = true;
            yParent = parent;
        }
        
        dfs(root.left, level+1, root, x, y);
        dfs(root.right, level+1, root, x, y);
    }
}