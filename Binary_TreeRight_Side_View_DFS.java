// 199. Binary Tree Right Side View - https://leetcode.com/problems/binary-tree-right-side-view/
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

 
 // Traversing right 
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<Integer>();
        if(root==null)
            return result;
        
        helper(root,0);
        return result;
    }
    
    private void helper (TreeNode root, int level) {
        // base
        if(root == null) return;
        
        // logic
        if(result.size()==level)
            result.add(root.val);
        else
            result.set(level, root.val);
        
        helper(root.left, level+1);
        helper(root.right, level+1);
    }
}

// --------------------------------------------||||||||||||||||||||||||||||||||||||||||||||---------------------------------------------------- //

 // Traversing left and then overriding rigth values

 class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null) 
            return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int sz = queue.size();
            
            for(int i=0; i<sz; i++){
                TreeNode curr = queue.poll();
                
                // last node in every level
                if(i == sz-1)
                    result.add(curr.val);
                
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
        }
        return result;
    }
}