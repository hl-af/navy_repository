package Jan2;

public class FindArray {
	public boolean Find(int target, int [][] array){
        int rowCount = array.length;
        int colCount = array[0].length;
        for(int i =0;i<rowCount;i++){
            for(int j=0;j<colCount;j++){
                if(array[i][j]==target)
                    return true;
            }
        }
        return false;
    }
	public static void main(String[] args){
		int [][] array={{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(3/2);
		System.out.println(new FindArray().Find(22, array));	
	}
}
