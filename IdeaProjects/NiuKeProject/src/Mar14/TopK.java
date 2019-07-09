package Mar14;

import java.util.PriorityQueue;

public class TopK {
    public static void main(String[] args){
        PriorityQueue pq  = new PriorityQueue();
        pq.add(10);
        pq.add(3);
        pq.add(4);
        pq.add(12);
        pq.offer(33);
        System.out.println(pq.poll());



    }
}
