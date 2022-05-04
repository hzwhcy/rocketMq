package com.han.zhaohang;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        scanner.nextLine();
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        int aa = 0;
        for (int i = 0; i < m; i++) {
            int num = scanner.nextInt();
            map2.put(i,num);
            if(!set.contains(num)){
                set.add(num);
                if(map.containsKey(num)){
                    aa += map.get(num);
                }
            }
            map1.put(i,aa);
        }
        scanner.nextLine();
        int q = scanner.nextInt();
        scanner.nextLine();
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int index1 = scanner.nextInt();
            int index2 = scanner.nextInt();

            if(index2 == index1 || map1.get(index2-1) == map1.get(index1-1)){
                if(map.containsKey(map2.get(index2-1))){
                    ans[i] = map.get(map2.get(index2-1));
                }
                ans[i] = 0;
            }else{
                ans[i] = map1.get(index2-1) - map1.get(index1-2);
            }
            scanner.nextLine();
        }
        for (int an : ans) {
            System.out.println(an);
        }
    }
}
