package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
다이나믹 프로그래밍을 이용한 문제 풀이
n - 2번째 인덱스 부터 n - 1 까지 가기 위해선 몇 번 거쳐야 하는지 체크
해당 위치의 숫자만큼 리스트를 만드는데 맨 끝 부분이 있다면 1
그렇지 않으면 갈 수 있는 위치들 중 최솟값에 1을 더한 값을 담는다.
단 0을 담으면 안된다.
arr[0]을 출력하면 답이 나온다
n이 1인 경우는 이미 맨 오른쪽으로 도착을 했기 때문에 0이 출력되어야 한다.
 */

public class No11060 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(n == 1){//1은 이미 맨 오른쪽으로 왔기 때문에 0 출력
            System.out.println(0);
            return;
        }

        int[] d_Arr = new int[n];
        for(int i = n - 2; i >= 0; i--){
            ArrayList<Integer> list = new ArrayList<>();//최대 갈 수 있는 인덱스를 담는다
            int max = i + arr[i];

            for(int j = i + 1; j < n && j <= max; j++){
                list.add(j);
            }

            if(list.contains(n - 1)){//맨 마지막 인덱스가 있다면 1로 설정
                d_Arr[i] = 1;
            }else if(list.size() > 0){//갈 수 있는 경로가 적어도 1개 이상이라면
                int min = Integer.MAX_VALUE;
                for(int j = 0; j < list.size(); j++){
                    if(d_Arr[list.get(j)] > 0){//0은 경로가 없다는 것이기에 0보다 큰 값중 작은값을 찾는다
                        min = Math.min(min, d_Arr[list.get(j)]);
                    }
                }

                if(min < Integer.MAX_VALUE){//경로를 찾았으면 최소 경로에 1을 더한다
                    d_Arr[i] = min + 1;
                }
            }
        }

        if(d_Arr[0] == 0){//경로가 없다는 뜻
            System.out.println(-1);
        }else{
            System.out.println(d_Arr[0]);
        }
    }
}