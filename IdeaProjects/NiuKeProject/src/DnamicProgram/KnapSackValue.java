package DnamicProgram;

public class KnapSackValue {
	public int knapSackvalue(int[] weight,int[] values,int n,int w){
		//n����Ʒ����������w����Ʒ��������weight
		int maxValue = -1;
		int[][] states = new int[n][w+1];//��Ϊ״̬0ҲҪ�������ڣ�������w+1
		for(int i = 0;i<n;i++)
			for(int j = 0;j<=w;j++)
				states[i][j] = -1;
		
		states[0][0] = 0; //û��װ
		states[0][weight[0]] =values[0]; //װ��
		for(int i = 1;i<n;i++){
			for(int j = w;j>=0;j--){  
				if(states[i-1][j]>0){
					states[i][j] = states[i-1][j]; //��i����Ʒ��װ
				}
			}
			for(int j = w-weight[i];j>=0;j--){  
				if(states[i-1][j]>0){//���״̬������·��Ҳ���Դﵽ����һ��ȥ�صĹ���
					int v = states[i-1][j] + values[i];
					if(states[i][j+weight[i]]<v){
						states[i][j+weight[i]] = v;
					}
						
					/*�����߼���ע����ת�ƾ�����˲���ֱ�Ӹ��������ֵֵ�����Ǵ�i-1״̬�ļ�ֵ������װ���ļ�ֵ
					 * if(states[i][j+weight[i]]<values[i])
						states[i][j+weight[i]] = values[i];//��i����Ʒװ
					*/
				}
			}
		}
		for(int j=w;j>=0;j--){
			if(states[n-1][j]>maxValue){
				maxValue = states[n-1][j];
			}
				
		}
		return maxValue;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = {3,4,8,9,6};
		int[] weight = {2,2,4,6,3};
		System.out.print(new KnapSackValue().knapSackvalue(weight,values, 5, 9));

	}

}
