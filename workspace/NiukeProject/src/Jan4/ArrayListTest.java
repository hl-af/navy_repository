package Jan4;
import java.util.ArrayList;
import java.util.Iterator;;
public class ArrayListTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add("huanglei");
		list.add("huangyunhao");
		for(String str:list){
			System.out.print(str+" ");
		}
		System.out.println();
		String[] list2Array =new String[list.size()]; //为什么string可以这样构造，构造方法里没有这样写法
		list.toArray(list2Array);
		for(int i=0;i<list2Array.length;i++){
			System.out.print(list2Array[i]);
		}
		System.out.println();
		//迭代器法
		Iterator itr = list.iterator();
		while(itr.hasNext()){
			System.out.print(itr.next());
		}
	}

}
