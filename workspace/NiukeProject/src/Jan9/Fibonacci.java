package Jan9;
//���ֽⷨ��˼·������Ѿ�������˾ͱ��������������Ͳ����ظ��ݹ������
//�����Ƽ��ķ�����ʹ��ѭ���ķ���
public class Fibonacci {
	private int[] a = new int[40]; //�����ʼ��Ĭ��ֵ�Ƕ���
    public int Fibonacci(int n) {
        int result = 0;
        if(n==0){
            a[0] = 0;
            return 0;
        }
        if(n==1){
            a[1] = 1;
            return 1;
        }
        if(a[n-1]!=0&&a[n-2]!=0){
            result = a[n-1] + a[n-2];
        }else if(a[n-1]!=0&&a[n-2]==0){
            result = a[n-1] + Fibonacci(n-2);
        }else{
            result = Fibonacci(n-1) + Fibonacci(n-2);
        }
        a[n] = result;
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(new Fibonacci().Fibonacci(3));

	}

}
