package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
길이가 n인 오르막 수의 개수를 구하는 문제 이 또한 DP로 해결
n이 1이면 각 숫자만큼이기 때문에 10 반환
이전 수가 9면 다음에 올 수는 9밖에 없다
n - 1번째 경우의 수와 하나 더 큰 값의 개수를 더하면 개수가 나온다
 */

public class No11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][10];
        arr[1] = new int[]{1,1,1,1,1,1,1,1,1,1};//n이 1일경우는 각 숫자당 하나씩

        for(int i = 2; i <= n; i++){
            arr[i][9] = 1;//9는 다음에 올 수가 무조건 하나
            for(int j = 8; j >= 0; j--){
                //i - 1번째 값과 j + 1번째 값을 더한다
                arr[i][j] = (arr[i - 1][j] + arr[i][j + 1]) % 10007;
            }
        }

        //n번째 값을 for문을 통해 더하는 과정
        int result = 0;
        for(int i = 0; i < 10; i++){
            result += arr[n][i];
            result %= 10007;
        }

        System.out.println(result);
    }
}
