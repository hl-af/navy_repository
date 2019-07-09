package Jan22;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val){
        this.val = val;
    }
    public void constructTree(TreeNode root,int[] valset,int i){
        if(2*i>valset.length-1) return;
        if(valset[2*i]!=-1){
            root.left = new TreeNode(valset[2*i]);
            constructTree(root.left,valset,i*2);
        }
        if(valset[2*i+1]!=-1){
            root.right = new TreeNode(valset[2*i+1]);
            constructTree(root.right,valset,i*2+1);
        }
    }
    public void searchTree(TreeNode root){
        if(root==null)
            return;
        System.out.print(root.val+" ");
        searchTree(root.left);
        searchTree(root.right);
    }
}
