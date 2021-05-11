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
