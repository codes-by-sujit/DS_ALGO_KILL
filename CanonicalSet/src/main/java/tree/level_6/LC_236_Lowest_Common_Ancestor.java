package tree.level_6;

import tree.level_1.TreeNode;

public class LC_236_Lowest_Common_Ancestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;

        if(root==p || root==q) return root;

        TreeNode leftSearch=lowestCommonAncestor(root.left,p,q);
        TreeNode rightSearch=lowestCommonAncestor(root.right,p,q);

        if(leftSearch!=null && rightSearch!=null) return root;
        if(leftSearch!=null) return leftSearch;
        return rightSearch;
    }
}
