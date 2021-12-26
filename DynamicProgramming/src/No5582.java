package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
배열을 생성 후 행은 s의 문자대로 주어지고, 열은 t의 문자대로 주어진다
이중 for문을 돌면서 s의 i번째 문자와 t의 j번째 문자가 동일할 경우
s의 i - 1번째 , t의 j - 1번째에 일치한 개수에 1을 더해 저장
반복하면서 max값을 갱신해 값을 출력한다
도움이 된 블로그 : https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-5582-%EA%B3%B5%ED%86%B5-%EB%B6%80%EB%B6%84-%EB%AC%B8%EC%9E%90%EC%97%B4-Java
 */

public class No5582 {

    static int[][] dp;//각 단어에 대한 dp 테이블

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        //행은 s의 문자와 관련 열은 t의 문자와 관련
        dp = new int[s.length() + 1][t.length() + 1];
        int max = 0;

        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < t.length(); j++){
                if(s.charAt(i) == t.charAt(j)){//s의 i번째 문자와 t의 j번째 문자가 일치할 경우
                    //현 위치에서 왼쪽 위 숫자에 1을 더해 저장
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    max = Math.max(max, dp[i + 1][j + 1]);//max값 갱신
                }
            }
        }

        System.out.println(max);
    }
}
