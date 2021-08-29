package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1. 맨 윗쪽과 맨 왼쪽 배열을 설정합니다. 만약 올 수 있다면 경로는 하나기 때문에 1로 설정합니다.
2. 그리고 각각의 배열을 돌게 됩니다.
3. 배열의 위쪽을 살핍니다. 위의 칸과의 간격과 map을 비교해 일치하면 위의 칸의 경로수를 누적합니다.
4. 배열 왼쪽을 살핍니다. 왼쪽 칸과의 간격과 map을 비교해 일치하면 왼쪽 칸의 경로수를 누적합니다.
 */

public class Jump {

    static int[][] map;//주어진 입력을 담기 위한 map
    static long[][] visit;//각 배열마다 해당 배열로 찾아올 수 있는 경로의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visit = new long[n][n];
        map = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //맨 윗줄 경로 경우의 수 설정
        for(int i = 1; i < n; i++){
            int search_index = 1;
            for(int j = i - 1; j >= 0; j--){
                if(map[0][j] == search_index && j == 0){//맨 위의 위치이면서 점프했을 때 오는 구간인 경우
                    visit[0][i] = 1;
                }

                if(map[0][j] == search_index && visit[0][j] > 0){//점프했을 때 오는 구간인 경우
                    visit[0][i] = 1;
                    break;
                }

                search_index++;
            }
        }

        //맨 왼쪽줄 경로 경우의 수 설정
        for(int i = 1; i < n; i++){
            int search_index = 1;
            for(int j = i - 1; j >= 0; j--){
                if(map[j][0] == search_index && j == 0){//맨 왼쪽에 위치이면서 점프했을 때 오는 구간인 경우
                    visit[i][0] = 1;
                }

                if(map[j][0] == search_index && visit[j][0] > 0){//점프했을 때 오는 구간인 경우
                    visit[i][0] = 1;
                    break;
                }

                search_index++;
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                search(i, j);
            }
        }

        System.out.println(visit[n - 1][n - 1]);

    }

    public static void search(int x, int y){
        int search_index = 1;//해당 구간에서 어느정도 차이나는지 설정하는 변수
        for(int i = y - 1; i >= 0; i--){//해당 구간 아래쪽을 살피는 경우
            if(map[x][i] == search_index){//점프했을 때 오는 구간인 경우
                visit[x][y] += visit[x][i];
            }

            search_index++;
        }


        search_index = 1;
        for(int i = x - 1; i >= 0; i--){//해당구간 왼쪽을 살피는 경우
            if(map[i][y] == search_index){//점프했을 때 오는 구간인 경우
                visit[x][y] += visit[i][y];
            }

            search_index++;
        }
    }
}
