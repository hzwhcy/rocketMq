package com.han.zhaohang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            scanner.nextLine();
            int[] sugar = new int[m];
            for (int j = 0; j < m; j++) {
                sugar[j] = scanner.nextInt();
            }
            list.add(i,sugar);
            scanner.nextLine();
        }
        for (int[] ints : list) {
            if(help(ints)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    public static boolean help(int[] nums){

        if(nums == null || nums.length == 0){
            return false;
        }
        int N = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 3 != 0){
            return false;
        }
        int target = sum / 3;

        boolean[][] dp = new boolean[N + 1][target + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while (target > 0) {
            for (int i = 1; i <= N; i++) {
                if (dp[i][target]) {
                    list.add(nums[i - 1]);
                    target -= nums[i - 1];
                    N = i - 1;
                    break;
                }
            }
        }

        int targett = sum / 3;
        int[] nu = new int[list.size()];
        for (int i = list.size() - 1; i >=0 ; i--) {
            nu[i] = list.get(i);
        }
        boolean[][] dp1 = new boolean[nu.length + 1][targett + 1];
        for (int i = 0; i <= nu.length; i++) {
            dp1[i][0] = true;
        }
        for (int i = 1; i <= nu.length; i++) {
            for (int j = 1; j <= targett; j++) {
                if (j < nu[i - 1]) {
                    dp1[i][j] = dp1[i - 1][j];
                } else {
                    dp1[i][j] = dp1[i - 1][j] | dp1[i - 1][j - nu[i - 1]];
                }
            }
        }


        return dp[N][target] & dp1[nu.length][targett];
//        int[] dp = new int[target + 1];
//        for(int i = 0; i < n; i++){
//            for(int j = target; j >= nums[i]; j--){
//                dp[j] = Math.max(dp[j],dp[j - nums[i]] + nums[i]);
//            }
//        }
//        return dp[target] == target;
    }
}
