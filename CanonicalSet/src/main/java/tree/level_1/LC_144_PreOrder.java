package tree.level_1;

import java.util.ArrayList;
import java.util.List;

public class LC_144_PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        parse(root, result);
        return result;
    }
    private void parse(TreeNode root, List<Integer> result){
        if(root==null) return;
        result.add(root.val);
        parse(root.left,result);
        parse(root.right,result);
    }
}
