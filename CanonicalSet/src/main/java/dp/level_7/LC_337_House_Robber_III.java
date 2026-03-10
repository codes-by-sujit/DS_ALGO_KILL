package dp.level_7;

import org.junit.Test;
import tree.level_1.TreeNode;

import java.util.*;

public class LC_337_House_Robber_III {
    public int rob(TreeNode root) {
        int[] temp=dfs(root);
        return Math.max(temp[0],temp[1]);
    }
    public int[] dfs(TreeNode node){
        if(node==null) return new int[]{0,0};
        int[] left= dfs(node.left);
        int[] right=dfs(node.right);

        int rob=node.val+left[1]+right[1];
        int skip=Math.max(left[0],left[1])+Math.max(right[0],right[1]);

        return new int[]{rob,skip};
    }

    @Test
    public void tc(){
        TreeNode root = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3,
                        new TreeNode(4),
                        null
                        )
        );
        System.out.println(this.rob(root));
    }
}
