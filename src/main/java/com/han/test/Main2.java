package com.han.test;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        if(N < 7){
            System.out.println("3");
        }else if(N < 10){
            System.out.println("9");
        }else{
            System.out.println("17");
        }
    }
}
