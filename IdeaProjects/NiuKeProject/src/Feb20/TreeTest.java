package Feb20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class TreeTest {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (q.peek() != null){
            TreeNode p = q.poll();
            al.add(p.val);
            System.out.println(p.val);
            if(p.left!=null) {
                q.add(p.left);
            }
            if(p.right!=null) {
                q.add(p.right);
            }
        }
        return al;
    }

    public static void main(String[] args){
        TreeNode tn = new TreeNode(1);
        tn.left = new TreeNode(2);
        tn.right = new TreeNode(3);
        tn.left.left = new TreeNode(4);
        tn.left.right = new TreeNode(5);
        tn.right.left = new TreeNode(6);
        tn.right.right = new TreeNode(7);
        new TreeTest().PrintFromTopToBottom(tn);
    }
}

