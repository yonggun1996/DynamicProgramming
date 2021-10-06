package com.company;
import java.io.*;
import java.util.*;

public class SellCard {

    static int[] result;//각 카드 개수를 살 때 최대 가격

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        result = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        result[1] = arr[1];//1개를 살 땐 카드 1개의 가격이 최대이기 때문에 그래도 옮겨 담는다

        for(int i = 2; i <= n; i++){
            //1번 카드를 i번 사는것과 카드 번호 자체를 사는것을 비교
            //큰 값을 max에 담는다
            //1부터 n - 1의 result값을 더한 값과 max를 비교
            //수 두개를 계속해서 가감
            //최종적으로 result[n]을 출력
            int num1 = 1;
            int num2 = i - 1;
            int max = Math.max(arr[1] * i, arr[i]);

            while(num1 <= num2){
                max = Math.max(max, result[num1] + result[num2]);
                num1++;
                num2--;
            }
            result[i] = max;
            System.out.println(max);
        }

        System.out.println(result[n]);
    }
}
