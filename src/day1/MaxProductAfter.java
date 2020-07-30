package day1;

import java.util.Scanner;

public class MaxProductAfter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //int res = integerBreak(n);
        int res = maxProductAfterCutting(n);
        System.out.println(res);
    }
    //方法一
    //先将基础的0，1，2，3这几个长度的最长的长度标记出来，然后后面的，用循环来不断的寻找，最长的长度是多少，将大问题用之前的问题来代替。
    public static int integerBreak(int n){
        int[] dp = new int[n+1]; //辅助空间
        for (int i = 2; i <= n; i++){ //从2开始计算值
            for (int j = 1; j < i; j++){
                dp[i] = Math.max(dp[i],Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    //方法二 动态规划
    public static int maxProductAfterCutting(int l)
    {
        if(l<2)
            return 0;
        if(l==2)
            return 1;
        if(l==3)
            return 2;

        int[] pro = new int[l+1]; //数组存储在每个地方减的最大值 最后一位就是最大值
        pro[0]=0;
        pro[1]=1;
        pro[2]=2;
        pro[3]=3;
        int max = 0;
        for(int i =4;i<=l;i++){ //从4开始依次减 我觉得做任何题都是遍历 先把外部情况清扫干净 留下核心序列
            max = 0;
            for(int j=1;j<=i/2;j++){
                int prod = pro[j]*pro[i-j];
                if(max<prod)
                    max=prod;

                pro[i] = max; //每比较因此就扔进当前位置 然后比较 直到找到最大值
            }
        }

        max = pro[l];
        return max;
    }

    //方法三 贪心算法
    //
    public int maxProductAfterCutting1(int l)
    {
        if(l<2)
            return 0;
        if(l==2)
            return 1;
        if(l==3)
            return 2;

        int timesOf3 = l/3;

        if(l-timesOf3*3==1){
            timesOf3-=1;
        }

        int timesOf2 = (l-timesOf3*3)/2;

        return (int)(Math.pow(3,timesOf3))*(int)(Math.pow(2,timesOf2));
    }
}
