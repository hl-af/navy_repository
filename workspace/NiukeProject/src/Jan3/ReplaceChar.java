package Jan3;

public class ReplaceChar {

	public String replaceSpace(StringBuffer str) {
		if(str==null||str.length()<0){
			return null;
		}
		int count = 0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==' '){
				count++;
			}
		}
		str.setLength(str.length()+count*2);
		int index = str.indexOf("are");
		System.out.println("are���±���"+index);
		for(int i=str.length()-count*2-1;i>=0;i--){
			if(str.charAt(i)!=' '){
				str.setCharAt(i+count*2, str.charAt(i));
			}
			else{
				str.setCharAt(i+count*2,'0');
				str.setCharAt(i+count*2-1,'2');
				str.setCharAt(i+count*2-2,'%');
				count=count-1;
			}
			
		}
		return str.toString();
		
		
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer str =new StringBuffer(" how old are you ");
		System.out.print(new ReplaceChar().replaceSpace(str));
	}

}
