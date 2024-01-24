package com.godtong.p239;

import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(1);
        priorityQueue.offer(34);
        priorityQueue.offer(23);

        while (priorityQueue.peek()!=34){
            System.out.println(priorityQueue.peek());
        }
    }
}
