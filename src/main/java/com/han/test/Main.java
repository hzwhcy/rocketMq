package com.han.test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        String[] ip1 = str[0].split("\\.");
        String[] ip2 = str[1].split("\\.");
        String[] subnet = str[2].split("\\.");
        StringBuilder stringBuilder = new StringBuilder();
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            int sub = Integer.parseInt(subnet[i]);
            int i1 = Integer.parseInt(ip1[i])&sub;
            int i2 = Integer.parseInt(ip2[i])&sub;
            if(i1 != i2){
                ans++;
            }
            stringBuilder.append(i1).append(".");
        }
        System.out.print((ans > 0 ? "0" : "1") + " ");
        System.out.println(stringBuilder.substring(0,stringBuilder.length() - 1).toString());
    }

}
