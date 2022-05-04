package com.han.test;
import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String start = sc.next();
        int n = sc.nextInt();
        sc.nextLine(); // 强制换行
        boolean[] v = new boolean[n];
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine().split(","));
        }
        sc.close();
        Queue<Integer> queue = new LinkedList<>();
        // 获取起始点
        for (int i = 0; i < n; i++) {
            for (String name : list.get(i)) {
                if (name.equals(start)) {
                    v[i] = true;
                    queue.add(i);
                    break;
                }
            }
        }
        // 广度优先，传播信息
        while (!queue.isEmpty()) {
            int temp = queue.remove();
            for (int i = 0; i < n; i++) {
                if (v[i]) continue;
                if (isUnion(list.get(temp), list.get(i))) {
                    v[i] = true;
                    queue.add(i);
                }
            }
        }
        // 统计人数
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (v[i]) {
                set.addAll(Arrays.asList(list.get(i)));
            }
        }
        System.out.println(set.size());
    }

    public static boolean isUnion(String[] a, String[] b) {
        HashSet<String> set = new HashSet<>();
        set.addAll(Arrays.asList(a));
        set.addAll(Arrays.asList(b));
        return a.length + b.length > set.size();
    }
}
