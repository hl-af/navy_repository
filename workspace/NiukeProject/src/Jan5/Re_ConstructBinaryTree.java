package Jan5;

public class Re_ConstructBinaryTree {
	public TreeNode reConstructBinaryTreePlus(int [] pre,int [] in){	
		for(int i = 0;i<in.length;i++){
			if(pre[0]==in[i]){
				TreeNode root = new TreeNode(in[i]);
				int[] preNew= new int[i-1];//数组不用初始化定义空间大小吗
				for(int j = 0;j<i-1;j++){
					preNew[j] = pre[j+1];
				}
				int[] inNew = new int[i-1];
				for(int j = 0;j<i-1;j++){
					inNew[j] = in[j];
				}
				TreeNode leftNode = reConstructBinaryTreePlus(preNew,inNew);
				int[] preNew2 = new int[pre.length-i];//数组不用初始化定义空间大小吗
				int k = 0;
				for(int j = i+1;j<pre.length;j++){
					preNew2[k] = pre[j];
					k++;
				}
				int[] inNew2 =  new int[in.length-i];
				k = 0;
				for(int j = i+1;j<in.length;j++){
					inNew2[k] = in[j];
					k++;
				}
				TreeNode rightNode = reConstructBinaryTreePlus(preNew2,inNew2);
				root.left = leftNode;
				root.right = rightNode;
				
				return root;
			}
		}
		
	}
	public TreeNode reConstructBinaryTree(int [] pre,int [] in,int startIndex,int endIndex){
        int flag = 0;
        int i=0;int j = 0;
        if(startIndex>endIndex){
        	return null;
        }
		if(startIndex == endIndex){
			TreeNode rootNode = new TreeNode(in[startIndex]);
        	return rootNode;
        }
        for(j = 0;j<pre.length;j++){
        	for(i = startIndex;i<=endIndex;i++){   //这里的i在下面已经不能用了
        		if(in[i]==pre[j]){
        			System.out.println(in[i] +" ");
        			flag = 1;
        			break;
        		}
        	}
        	if(flag == 1){
        		break;
        	}
        }
        TreeNode leftNode = reConstructBinaryTree(pre,in,startIndex,i-1);
        TreeNode rightNode = reConstructBinaryTree(pre,in,i+1,endIndex);
        TreeNode rootNode = new TreeNode(in[i]);
        System.out.println(in[i] +" ");
        rootNode.left = leftNode;
        rootNode.right = rightNode;
        return rootNode;
    }
	public void preFind(TreeNode t){
		if(t==null)
			return;
		System.out.print(t.val + "->");
		preFind(t.left);
		preFind(t.right);
	}
	public void midFind(TreeNode t){
		if(t==null)
			return;
		midFind(t.left);
		System.out.print(t.val + "->");
		midFind(t.right);
	}
	public static void main(String[] args){
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		Re_ConstructBinaryTree action = new Re_ConstructBinaryTree();
		TreeNode node = action.reConstructBinaryTreePlus(pre, in);
		action.preFind(node);
	}
}
