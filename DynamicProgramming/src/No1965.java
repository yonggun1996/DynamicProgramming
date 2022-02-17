package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] result = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result[0] = 1;//상자가 하나일 경우는 겹칠 수 없기 때문에 1로 데이터 저장
        int answer = 1;

        //이전 값들 중 입력받은 arr이 작고 살펴본 값들 중 가장 큰 값을 구하는 for문
        for(int i = 1; i < n; i++){//이전에 입력 받은 값들을 살피는 for문
            int max = 0;
            for(int j = 0; j < i; j++){//result값 중 가장 큰 값을 구하는 for문
                if(arr[i] > arr[j] && result[j] >= max){
                    max = result[j];
                }
            }

            result[i] = max + 1;//가장 많은 상자와 현재 상자를 더해 저장한다
            answer = Math.max(answer, result[i]);//살펴본 값들을 하나하나 따져서 제일 큰 값 갱신
        }

        System.out.println(answer);
    }
}
