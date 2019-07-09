package Jan9;

public class Fibonacci2 {
	public int Fibonacci(int n) {
		int left_nOne = 0,right_nTwo = 0,result = 0;
		if(n==0){
			return 0;
		}
		if(n==1||n==2){
			return 1;
		}
		left_nOne = 1;
		right_nTwo = 1;
		for(int i =3 ;i<=n;i++){
			result = left_nOne + right_nTwo;
			right_nTwo = left_nOne;
			left_nOne = result;
		}
		return result;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(new Fibonacci2().Fibonacci(5));
	}

}
