package Jan18;
//输入一个链表，输出该链表中倒数第k个结点。
//考的是代码的鲁棒性和只遍历一遍的技巧
//鲁棒性：空指针，k=0，k小于节点的长度
//只遍历一遍：用两个指针，间距为K。
public class FindKthToTail {
    public ListNode findKthToTail(ListNode head,int k){
        ListNode p,q;
        p = head;
        if(head==null||k==0){
            return null;
        }
        for(int i = 0;i<(k-1);i++){
            if(p.next==null){
                return null;
            }
            p = p.next;
        }
        q = head;
        while(p.next!=null){
            p = p.next;
            q = q.next;
        }
        return  q;
    }
}
