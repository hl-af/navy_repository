package Jan10;

public class JumpFloor {
	public int jumpFloor(int target) {
        int num = 0;
        if(target==0){
            num++;
            return num;
        }
        if(target<0){
        	return 0;
        }
        System.out.print(target+" ");
        num = jumpFloor(target-1)+ jumpFloor(target-2);
        return num;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(new JumpFloor().jumpFloor(5));
	}

}
