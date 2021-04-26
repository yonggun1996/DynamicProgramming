# Dynamic programming 알고리즘

### Dynamic programming 알고리즘이란? : 메모리를 적절히 사용해서 수행시간을 줄이는 방법입니다.

### Dynamic programming 사용 조건

- 큰 문제를 작은 문제로 나눌 수 있어야 합니다.
- 동일한 작은 문제를 반복적으로 해결할 수 있어야 합니다.
※ 추후에 피보나치 수열을 예시로 조건에 부합하는지 보여드리겠습니다.

### 접근법

-상향식 접근법 : 맨 처음 알고리즘 부터 차근차근히 풀어나가는 방법입니다.
-하향식 접근법 : 재귀적으로 깊이 파고드는 와중에 이미 탐색했던 값이 있으면 그 값을 꺼내와 계산을 합니다.

### 피보나치수열로 알아보는 DP(Dynamic programming)

우선 피보나치 연산이 왜 동적계획법으로 접근이 가능한지 이야기 하겠습니다.

https://user-images.githubusercontent.com/68115246/115502786-6b1df000-a2b0-11eb-9ed4-140512a086aa.PNG

첫번째로 f(4)를 구하기 위해선 f(3)과 f(2)를 알아야 하고 그 아래 숫자도 마찬가지 입니다. 이로서 큰 문제를 작은 문제로 나눌 수 있고
두번째로 위 그림에서 f(2), f(1), f(0)를 반복적으로 호출하는걸 볼 수 있습니다. 이렇게 동일한 함수를 반복적으로 불러 해결을 하고 두개의 조건이 맞아 이 문제를 동적계획법으로 풀 수 있습니다.

이 알고리즘을 알기 전에 단순한 재귀적인 호출로 문제를 풀었었습니다. 하지만 이때 생기는 문제는 수가 커지면 재귀함수를 호출해야하는 수가 많아져 StackOverFlow를 유발하는 단점이 있었습니다.
이 문제를 동적계획법으로 푼다면 좀 더 간단하고 빠르게 풀 수 있습니다.

-백준 알고리즘 1003번(피보나치 함수)문제 예시

```java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Fibonachi {
	
	static int[][] static_arr = new int[41][2]; //피보나치 함수에서 구한 연산을 담는 배열을 먼저 선언
	
	public int[] fibonachi(int n) {
		if(n == 0) {
			int[] arr = {1,0};//f(0)은 0이 1번 호출된다
			return arr;
		}else if(n == 1) {
			int[] arr = {0,1};//f(1)은 1이 1번 호출된다
			return arr;
		}else if(static_arr[n][0] != 0 && static_arr[n][1] != 0) {//이미 계산한 값이 있다면
			int num1 = static_arr[n][0];//0이 호출된 수
			int num2 = static_arr[n][1];//1이 호출된 수
			int[] arr = {num1, num2};
			return arr;
		}else {
			int[] arr1 = fibonachi(n - 1);//f(n-1)이 0과 1을 몇 번 호출했는지 확인
			int[] arr2 = fibonachi(n - 2);//f(n-2)가 0과 1을 몇 번 호출했는지 확인
			
			int[] arr = new int[2];
			for(int i = 0; i < 2; i++) {
				//각각 0이 호출된 수와 1이 호출된 수를 더해 선언한 배열에 저장한다
				arr[i] = arr1[i] + arr2[i];
				static_arr[n][i] = arr1[i] + arr2[i];
			}
			
			return arr;
		}
	}

	public static void main(String[] args) throws IOException {
		Fibonachi f = new Fibonachi();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		static_arr[1][1] = 1;
		static_arr[0][0] = 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			int[] arr = f.fibonachi(n);
			
			for(int j = 0; j < 2; j++) {
				bw.write(String.valueOf(arr[j]) + " ");
			}
			bw.newLine();
			
		}
		
		bw.flush();
		bw.close();
	}//main

}

```

이 코드는 수가 주어질 때 0과 1이 몇 번 호출됐는지 나타내는 코드입니다. 
static_arr에서 이미 구한 값들을 담아 나중에 해당 값을 호출하면 static_arr에 있는 값을 반환해 시간을 줄일 수 있습니다.

이러한 방법으로 피보나치 수열을 빠르게 구할 수 있습니다.
