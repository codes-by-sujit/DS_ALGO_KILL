package tree.level_1;

import java.util.ArrayList;
import java.util.List;

public class LC_145_PostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        parse(root, result);
        return result;
    }

    private void parse(TreeNode root, List<Integer> result){
        if(root==null) return;

        parse(root.left,result);
        parse(root.right,result);
        result.add(root.val);
    }
}
