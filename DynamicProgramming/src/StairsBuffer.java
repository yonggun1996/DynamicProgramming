import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class StairsBuffer {
	
	static int[] stair_score;//�Է¹��� ����� ����
	static int[][] sum_score;//���� ��ġ�� ������ġ�� ������ ���� �迭
	//sum_score�� Dynamic Programming ������ ���� �̸� ���� ��� ���߿� ���� �ҷ��� 

	public static void main(String[] args) throws IOException {
		StairsBuffer s = new StairsBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		stair_score = new int[count + 1];
		sum_score = new int[count + 1][count + 1];
		
		StringTokenizer st;
		for(int i = 1; i <= count; i++) {
			st = new StringTokenizer(br.readLine());
			stair_score[i] = Integer.parseInt(st.nextToken());
		}
		
		if(count == 1) {
			System.out.println(stair_score[1]);
		}else {
			int num1 = s.search(count - 1, true);
			int num2 = s.search(count - 2, false);
			
			if(num1 < num2) {
				bw.write(String.valueOf(num2 + stair_score[count]));
			}else {
				bw.write(String.valueOf(num1 + stair_score[count]));
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	//num�� �θ𿡼� ������ �� ��, flag�� ������ ��ĭ�� ������ Ȯ���ϴ� ����
	public int search(int num, boolean flag) {
		if(flag) {//��ĭ�� ���� ��
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
		}else {//�� ĭ ������ ��
			int nextindex1 = num - 1;
			int nextindex2 = num - 2;
			
			int num1 = 0;
			int num2 = 0;
			
			if(num == 0) {
				return 0;
			}else if(num == 1) {
				return stair_score[1];
			}
			
			//�ű⼭ ��ĭ �ڷ� �� ���
			if(sum_score[nextindex1][num] != 0) {
				num1 = sum_score[nextindex1][num];
			}else {
				num1 = search(nextindex1, true);
				sum_score[nextindex1][num] = num1 + stair_score[num];
			}
			
			//�ű⼭ ��ĭ �ڷ� �� ���
			if(sum_score[nextindex2][num] != 0) {
				num2 = sum_score[nextindex2][num];
			}else {
				num2 = search(nextindex2, false);
				sum_score[nextindex2][num] = num2 + stair_score[num];
			}
			
			//���� ���� �ջ��� ����� ū ���� ��ȯ�Ѵ�
			if(sum_score[nextindex1][num] < sum_score[nextindex2][num]) {
				return sum_score[nextindex2][num];
			}else {
				return sum_score[nextindex1][num];
			}
		}
	}
}
