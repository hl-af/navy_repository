package Jan3;

public class ReplaceChar2 {

	public String replaceSpace(StringBuffer str) {
		if(str==null||str.length()<0){
			return null;
		}
		return str.toString().replaceAll(" ","%20");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer str =new StringBuffer("how old are you ");
		System.out.print(new ReplaceChar().replaceSpace(str));
	}

}
