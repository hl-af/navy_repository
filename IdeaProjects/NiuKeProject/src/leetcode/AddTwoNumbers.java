package leetcode;
/*
* 2 两数相加
* */
public class AddTwoNumbers {
    public static void main(String[] args){

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num = 0;//位数计数
        int layer = 0;//进位计数
        int sum = 0;
        int a = 0;int b = 0;
        ListNode list = new ListNode(-1);
        ListNode p = list;
        while (l1!=null||l2!=null||layer!=0) {
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            if ((a + b + layer) < 10) {
                sum += (a + b + layer) * Math.pow(10, num);
                p.next = new ListNode(a + b + layer);
                p = p.next;
                layer = 0;
            } else {
                p.next = new ListNode((a+b+layer)%10);
                layer = 1;
                p = p.next;
            }
            a = 0;b = 0;
            num++;
        }
        return list.next;
    }
}
