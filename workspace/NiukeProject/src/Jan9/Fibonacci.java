package Jan9;
//这种解法的思路是如果已经计算过了就保存起来，这样就不用重复递归调用了
//文章推荐的方法是使用循环的方法
public class Fibonacci {
	private int[] a = new int[40]; //数组初始化默认值是多少
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
