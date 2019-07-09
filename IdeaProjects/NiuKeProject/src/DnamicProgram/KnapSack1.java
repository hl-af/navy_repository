package DnamicProgram;
/*
 * ????0-1????????
 * */
public class KnapSack1 {
	public int knapSack1(int[] weight,int n,int w){
		//n???????????????w?????????????weight
		int max = 0;
		boolean[][] states = new boolean[n][w+1];//?????0?????????????????w+1
		states[0][0] = true; //????
		states[0][weight[0]] =true; //???
		for(int i = 1;i<n;i++){
			for(int j = 0;j<=w;j++){  //?????????????????????????????????????
				if(states[i-1][j]==true){
					states[i][j] = true; //??i????????
					if(j+weight[i]<=w)
						states[i][j+weight[i]] = true;//??i??????
				}
			}
			//???????for(j...)?????
			/*
			 * for (int j = w-items[i]; j >=0;j--)
			 * ????????????
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
