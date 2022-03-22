package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
3 x 2 타일의 경우의 수는 3개, 3 x n의 타일의 개수는 2개가 더 추가된다
한 쪽에 3 x n의 타일이 고정적으로 있다고 했을 때 옆의 타일은 몇 개가 붙는지에 착안해 점화식 완성
 */

public class No2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n % 2 == 1) {//n이 홀수로 오면 방법이 없기 때문에 0으로 출력후 프로그램 종료
            System.out.println(0);
            return;
        }

        int[] count = new int[31];//3 x n의 벽돌 개수가 담긴 배열
        int[] dp = new int[31];//3 x n의 경우의 수를 담은 배열

        count[2] = 3;//3 x 2의 개수는 3개 나머지는 2개이다.
        for(int i = 4; i <= 30; i += 2){
            count[i] = 2;
        }

        dp[0] = 1;//계산 편의상 0번 배열에 1 삽입
        dp[2] = 3;//3 x 2의 경우의 수는 3개

        for(int i = 4; i <= n; i += 2){
            for(int j = 2; j <= i; j += 2){//한 쪽에 3 x j의 벽돌이 있고 이에 추가하는 과정
                dp[i] += (dp[i - j] * count[j]);//i - j 벽돌이 채워지고 남은 벽돌을 채우기 위한 점화식
            }
        }

        System.out.println(dp[n]);
    }
}
