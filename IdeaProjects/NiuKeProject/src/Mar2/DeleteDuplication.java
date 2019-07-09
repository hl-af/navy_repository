package Mar2;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class DeleteDuplication {

    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null){
            return null;
        }
        if(pHead.next==null){
            return pHead;
        }
        ListNode p = pHead;
        while(p!=null&&p.next!=null){
            if(p.val < p.next.val){
                System.out.println(p.val);
                p = p.next;
                System.out.println("test");
            }
            else{

                ListNode q = p.next;
                p.next = q.next;
                System.out.println("tiaozheng"+p.next.val);
            }
        }
        return pHead;
    }
    public ListNode deleteDuplication2(ListNode pHead) {
        int flag = 0;
        if(pHead==null){
            return null;
        }
        ListNode p = pHead.next;
        while((p!=null)&&(pHead.val == p.val)){
            while((p!=null)&&(pHead.val == p.val))
                p = p.next;
            flag  = 1;
        }
        if(flag == 1) pHead = p;
        ListNode pre = pHead;
        while((pre!=null)&&(pre.next!=null)){
            p = pre.next;
            if((p.next!=null)&&(p.val == p.next.val)){
                while(p.val == p.next.val){
                    p = p.next;
                }
                p = p.next;//如果不写这一步，p指向的是最后的一位
                pre.next = p;
            }else{
                pre = pre.next;
            }
        }
        return pHead;

    }
    public ListNode deleteDuplication3(ListNode pHead)
    {
        ListNode preNode=null;
        ListNode pNode=pHead;
        ListNode pNext=pNode;//用于存储要删除的点
        while(pNode!=null){
            System.out.println(pNode.val);
            boolean flag=false;

            if((pNode.next!=null)&&(pNode.val==pNode.next.val)){
                flag=true;
            }System.out.println("test1");
            if(!flag){
                preNode = pNode;
                pNode = pNode.next;//
                pNext = pNode.next;//

                System.out.println("test3");
            }else{

                while((pNext!=null)&&(pNext.val==pNode.val)){//
                    pNext=pNext.next;
                }System.out.println("test2");
                if(preNode.next==pHead){
                    pHead = pNext;
                }
                pNode = pNext;
                preNode.next=pNode;
            }
        }
        return pHead;
    }
    public static void main(String[] args){
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(3);
        ln.next.next.next = new ListNode(3);
        ln.next.next.next.next = new ListNode(4);
        ln = new DeleteDuplication().deleteDuplication3(ln);
        System.out.println(ln.val);
    }
}
