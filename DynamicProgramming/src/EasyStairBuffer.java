import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EasyStairBuffer {
	
	static long[][] s;//�� ������ ���ϴ� ���� ��� �迭

	public static void main(String[] args) throws NumberFormatException, IOException {
		EasyStairBuffer es = new EasyStairBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		s = new long[N][10];
		for(int i = 0; i < 10; i++) {
			s[0][i] = 1;//0 ������ ���� ��� 1�� �����Ѵ�
		}
		
		long answer = 0;
		for(int i = 1; i <= 9; i++) {
			long n = es.search(i, N - 1);
			answer += n;
		}
		
		bw.write(String.valueOf(answer % 1000000000));
		bw.flush();
		bw.close();
		
	}
	
	public long search(int num, int level) {
		if(level == 0) {//0������ ���� ��� �迭�� �����´�. ����� 1000000000�� ������� �������ǿ� ���� ���� ���� �������� �����Ѵ�
			return s[level][num] % 1000000000;
		}else if(s[level][num] != 0) {//���� ��ϵ������� 1000000000�� �������� �����Ѵ�
			return s[level][num] % 1000000000;
		}else {
			if(num == 0) {//���� 0�̶�� ������ �� �� �ִ� ���� 1���̴�.
				long n = search(1, level - 1);
				s[level][num] = n;
				return n % 1000000000;
			}else if(num == 9) {//���� 9��� ������ �� �� �ִ� ���� 8�A�̴�.
				long n = search(8, level - 1);
				s[level][num] = n;
				return n % 1000000000;
			}else {//������ ���ڴ� +1, -1�� �� �� �ִ�.
				long n1 = search(num - 1, level - 1);
				long n2 = search(num + 1, level - 1);
				s[level][num] = n1 + n2;
				return (n1 + n2) % 1000000000;
			}
		}
	}

}
