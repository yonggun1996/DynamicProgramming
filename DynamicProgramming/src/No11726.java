package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
완전탐색으로 해결할 경우 시간 초과 발생
n이 1이면 1가지 경우(1), 2면 2가지 경우(1,1),(2)
그 뒤로는 2*1 블록을 쌓은 후 가로축이 n - 1개를 쌓는 수와
1 * 2 블록을 n - 2개의 쌓는 수를 더해 배열의 n번째 원소를 출력한다
 */

public class No11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[1001];
        arr[1] = 1;
        arr[2] = 2;

        for(int i = 3; i < n + 1; i++){
            arr[i] = (arr[i - 2] + arr[i - 1]) % 10007;
        }

        System.out.println(arr[n]);
    }
}
