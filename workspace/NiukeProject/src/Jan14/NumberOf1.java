package Jan14;

public class NumberOf1 {
	public int numberOf1(int n) {
        int times = 31;
        int count = 0;
        while((times--)>0){  
        	System.out.println(n);
        	int flag = n&1;
            if(flag==1){
                count++;
            }
            n = n>>1;
        }
        if(n<0){
            count = count +1;
        }
        return count;          
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(new NumberOf1().numberOf1(214748367
));
	}

}
