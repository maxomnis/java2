package TestList;

import java.util.PriorityQueue;

/**
 * PriorityQueue 插入的时候顺序会按照值的顺序排列
 */
public class TestPriorityQueue {
    public static void main(String[] args)
    {
        PriorityQueue pq = new PriorityQueue();

        //插入四个元素
        pq.offer(6);
        pq.offer(-8);
        pq.offer(-60);
        pq.offer(19);

        //输出[-60, 6, -8, 19]
        System.out.println(pq);

        //输出-60
        System.out.println(pq.poll());
    }
}
