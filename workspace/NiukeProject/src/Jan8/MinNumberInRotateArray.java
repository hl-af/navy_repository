package Jan8;

public class MinNumberInRotateArray {
	public int minNumberInRotateArray(int [] array) {
	    int low = 0;
		int high = array.length-1;
		int mid = (low + high)/2;
		while((array[low] < array[mid])){
			if(array[mid] > array[high]){
				low = mid + 1;
			}
			else{
				high = mid - 1;
			}
			mid = (low + high)/2;
			while((array[low]==array[mid])&&(array[low]==array[low+1])){
					low = mid + 1;
					mid = (low + high)/2;
			}
			while((array[high]==array[mid])&&(array[high]==array[high-1])){
				high = mid - 1;
				mid = (low + high)/2;
		}
			System.out.println("low="+low+" mid= "+mid+" high="+high);
		}
		
		return array[mid];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinNumberInRotateArray MIRA = new MinNumberInRotateArray();
		int[] array = {4,5,5,6,7,8,9,9,9,10,10,10,10,10,10,1,2,3,3,3,3,3};
		for(int i =0;i<array.length;i++){
			System.out.print(array[i]+"  ");
		}System.out.println();
		for(int i =0;i<array.length;i++){
			System.out.print(i+"  ");
		}System.out.println();
		System.out.print(MIRA.minNumberInRotateArray(array));
	}

}
