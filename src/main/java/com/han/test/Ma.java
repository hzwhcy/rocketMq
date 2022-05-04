package com.han.test;

import java.util.Deque;
import java.util.LinkedList;

public class Ma {

    public static void main(String[] args) {

        Deque<Integer> stack = new LinkedList<>();
        Deque<Integer> help = new LinkedList<>();
        stack.push(4);
        stack.push(2);
        stack.push(1);
        stack.push(3);

        while(!stack.isEmpty()){
            int temp = stack.pop();

            while(!help.isEmpty() && temp < help.peek()){
                stack.push(help.pop());
            }
            help.push(temp);
        }
        for (Integer integer : help) {
            System.out.println(integer);
        }
    }
}
