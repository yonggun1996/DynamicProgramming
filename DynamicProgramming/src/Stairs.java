import java.util.Scanner;

public class Stairs {
	
	static int[] stair_score;//입력받은 계단의 점수
	static int[][] sum_score;//현재 위치와 이전위치의 점수를 담은 배열
	//sum_score는 Dynamic Programming 구현을 위해 미리 값을 담고 나중에 값을 불러와 

	public static void main(String[] args) {
		Stairs s = new Stairs();
		Scanner in = new Scanner(System.in);
		
		int count = in.nextInt();
		stair_score = new int[count + 1];
		sum_score = new int[count + 1][count + 1];
		
		for(int i = 1; i <= count; i++) {
			stair_score[i] = in.nextInt();
		}
		
		if(count == 1) {
			System.out.println(stair_score[1]);
		}else {
			int num1 = s.search(count - 1, true);
			int num2 = s.search(count - 2, false);
			
			if(num1 < num2) {
				System.out.println(num2 + stair_score[count]);
			}else {
				System.out.println(num1 + stair_score[count]);
			}
		}
	}
	
	//num은 부모에서 연산을 한 수, flag는 이전에 한칸만 뺐는지 확인하는 변수
	public int search(int num, boolean flag) {
		if(flag) {//한칸만 왔을 때
			int nextindex = num - 2;
			
			if(num == 0) {
				return 0;
			}else if(num == 1) {
				return stair_score[1];
			}else if(sum_score[nextindex][num] != 0) {
				return sum_score[nextindex][num];
			}else {
				int result = search(nextindex, false);
				sum_score[nextindex][num] = result + stair_score[num];
				return sum_score[nextindex][num];
			}
		}else {//두 칸 옯겼을 때
			int nextindex1 = num - 1;
			int nextindex2 = num - 2;
			
			int num1 = 0;
			int num2 = 0;
			
			if(num == 0) {
				return 0;
			}else if(num == 1) {
				return stair_score[1];
			}
			
			//거기서 한칸 뒤로 갈 경우
			if(sum_score[nextindex1][num] != 0) {
				num1 = sum_score[nextindex1][num];
			}else {
				num1 = search(nextindex1, true);
				sum_score[nextindex1][num] = num1 + stair_score[num];
			}
			
			//거기서 두칸 뒤로 갈 경우
			if(sum_score[nextindex2][num] != 0) {
				num2 = sum_score[nextindex2][num];
			}else {
				num2 = search(nextindex2, false);
				sum_score[nextindex2][num] = num2 + stair_score[num];
			}
			
			//이전 수와 합산한 결과중 큰 값을 반환한다
			if(sum_score[nextindex1][num] < sum_score[nextindex2][num]) {
				return sum_score[nextindex2][num];
			}else {
				return sum_score[nextindex1][num];
			}
		}
	}
}
