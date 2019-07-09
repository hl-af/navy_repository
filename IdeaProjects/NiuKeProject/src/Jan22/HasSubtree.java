package Jan22;

public class HasSubtree {
    public boolean hasSubtree(TreeNode root1 ,TreeNode root2){
        if(root1==null||root2==null){
            return false;
        }
        if(root1.val==root2.val){
            if(doesHasTreeSet(root1,root2))
                return true;
        }
        boolean flag1 = hasSubtree(root1.left,root2);
        boolean flag2 = hasSubtree(root1.right,root2);
        return flag1 == true || flag2 == true;
    }

    public boolean doesHasTreeSet(TreeNode root1,TreeNode root2){
        if(root2==null){ //两个连续if设计很巧妙，第一个if判断第二棵树是否到叶子节点，到了就结束了
            return true;
        }
        if(root1==null){//如果第二棵树没有到叶子节点，第一棵树到了叶子节点，那一定不是子结构
            return false;
        }
        if(root1.val!=root2.val){//如果两个值不相等，一定不是
            return false;
        }
        //继续递归
        return doesHasTreeSet(root1.left,root2.left)&&doesHasTreeSet(root1.right,root2.right);
    }
    public static void main(String[] args){
        int[] tree = {-1,8,8,7,9,2,-1,-1,-1,-1,4,7};
        int[] sample = {-1,8,9,2};

        TreeNode root1 = new TreeNode(tree[1]);
        root1.constructTree(root1,tree,1);
        root1.searchTree(root1);
        System.out.println();
        TreeNode root2 = new TreeNode(sample[1]);
        root2.constructTree(root2,sample,1);
        root2.searchTree(root2);
        System.out.println();
        try {
            System.out.println(new HasSubtree().hasSubtree(root1, root2));
        }catch (NullPointerException e){
            System.out.println(e);
        }
    }
}
