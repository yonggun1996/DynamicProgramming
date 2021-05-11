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

### 냅색 알고리즘 : 흔히들 이 알고리즘은 배낭문제 알고리즘으로 알고 있습니다. 배낭에 넣을 수 있는 최대 용량과 각 짐에 가치가 주어지면 최대용량내에 가장 많은 가치를 넣는 방법을 찾아내는 알고리즘 입니다.

이 알고리즘을 생각할 때 여러 방법을 생각할 수 있습니다.

1. 무게가 낮은 것부터 담아보기
예를 들어 1kg, 3kg, 5kg 물건이 있고 각각의 가치는 2,4,7이라고 가정합시다. 참고로 용량은 5kg입니다.

무게가 낮은 것 부터 들어간다면 1kg, 3kg 2개가 들어가고 가치는 6이 됩니다. 하지만 5kg 하나를 넣으면 가치는 7이 되기 때문에 이 방법은 틀리는 경우가 나올 수 있습니다.

2. 가치가 큰 것부터 넣기
위와 무게는 동일하게 1kg, 3kg, 5kg 물건이 있고, 가치는 각각 2,4,5 라고 가정합시다. 마찬가지로 용량은 5kg 입니다.

가치가 큰 것부터 들어가면 5kg 하나만 들어갈 수 있으며 가치는 5 입니다. 하지만 1kg, 3kg물건을 넣으면 가치는 6이 되기 때문에 이 방법도 틀리는 경우가 나올 수 있습니다.

그래서 이 문제는 이런식으로 풀어야 합니다.
※ 냅색 알고리즘 문제를  푸는데 가장 도움이 된 블로그 : https://chanhuiseok.github.io/posts/improve-6/

이 블로그의 내용을 토대로 하면
기존 무게의 최대 가치와 (최대무게 - 들어온 무게) 인덱스와 들어온 가치를 비교해 새로 들어온 가치가 크다면 갱신 그렇지 않으면 유지를 하는 방법입니다.

-소스코드
```java
import java.util.Scanner;

public class Backpack {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int max_weight = in.nextInt();
		int[] weight = new int[max_weight + 1];
		
		int[][] arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = max_weight; j - arr[i][0] >= 0; j--) {
				if(weight[j] < weight[j - arr[i][0]] + arr[i][1]) {//기존 무게의 최대 가치가 최대무게 - 들어온 무게 의 인덱스 와 새로 들어온 가치를 더한 값보다 작으면 갱신
					weight[j] = weight[j - arr[i][0]] + arr[i][1];
				}
			}
		}
		
		System.out.println(weight[max_weight]);
	}
	
}
```
