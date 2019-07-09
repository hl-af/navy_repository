package Jan4;
import java.util.ArrayList;

import Jan3.ReplaceChar;
//好像同一个文件中不能定义两个类
public class printListFromTailToHead {
	
	//ArrayList<Integer>这个写法不懂是什么意思
	public ListNode printListReverse(ListNode listNode) {
		ListNode tmp,p,q; //也可以用这样的方式声明变量
		p = listNode;
		q = p.next;
		while(q.next!=null){
			System.out.print("p="+ p.val);
			System.out.print("q="+ q.val);
			tmp = q.next;
			q.next = p;
			p =tmp;
			tmp = q;
			q = p.next;
			p.next = tmp;
		}
		return listNode;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode listNode = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		listNode.next = listNode2;
		ListNode listNode3 = new ListNode(3);
		listNode2.next = listNode3;
		ListNode listNode4 = new ListNode(4);
		listNode3.next = listNode4;
		ListNode list = new printListFromTailToHead().printListReverse(listNode);
		while(list.next!=null){
			System.out.print(list.val+" ");
			list = list.next;
		}
	}
}
