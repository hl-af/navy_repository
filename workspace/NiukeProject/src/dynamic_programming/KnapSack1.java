package dynamic_programming;
/*
 * 最简单的0-1背包问题
 * */
public class KnapSack1 {
	public int knapSack1(int[] weight,int n,int w){
		//n件物品，背包限制w，物品重量数组weight
		int max = 0;
		boolean[][] states = new boolean[n][w+1];//因为状态0也要考虑在内，所以是w+1
		states[0][0] = true; //没有装
		states[0][weight[0]] =true; //装了
		for(int i = 1;i<n;i++){
			for(int j = 0;j<=w;j++){  //这里的处理和原文不一样，因此下面有一个条件判断
				if(states[i-1][j]==true){
					states[i][j] = true; //第i件物品不装
					if(j+weight[i]<=w)
						states[i][j+weight[i]] = true;//第i件物品装
				}
			}
			//写成两个for(j...)的形式
			/*
			 * for (int j = w-items[i]; j >=0;j--)
			 * 后面可以不写判断
			 */
		}
		for(int j=w;j>=0;j--){
			System.out.println(states[n-1][j]);
			if(states[n-1][j]==true){
				max = j;
				break;
			}
				
		}
		return max;
		
	}
	public static void main(String[] args){
		int[] weight = {2,2,4,6,3};
		System.out.print(new KnapSack1().knapSack1(weight, 5, 9));
	}
}
