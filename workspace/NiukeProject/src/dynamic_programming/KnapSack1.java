package dynamic_programming;
/*
 * ��򵥵�0-1��������
 * */
public class KnapSack1 {
	public int knapSack1(int[] weight,int n,int w){
		//n����Ʒ����������w����Ʒ��������weight
		int max = 0;
		boolean[][] states = new boolean[n][w+1];//��Ϊ״̬0ҲҪ�������ڣ�������w+1
		states[0][0] = true; //û��װ
		states[0][weight[0]] =true; //װ��
		for(int i = 1;i<n;i++){
			for(int j = 0;j<=w;j++){  //����Ĵ����ԭ�Ĳ�һ�������������һ�������ж�
				if(states[i-1][j]==true){
					states[i][j] = true; //��i����Ʒ��װ
					if(j+weight[i]<=w)
						states[i][j+weight[i]] = true;//��i����Ʒװ
				}
			}
			//д������for(j...)����ʽ
			/*
			 * for (int j = w-items[i]; j >=0;j--)
			 * ������Բ�д�ж�
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
