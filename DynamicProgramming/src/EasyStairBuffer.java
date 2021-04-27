import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EasyStairBuffer {
	
	static long[][] s;//각 레벨에 속하는 수를 담는 배열

	public static void main(String[] args) throws NumberFormatException, IOException {
		EasyStairBuffer es = new EasyStairBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		s = new long[N][10];
		for(int i = 0; i < 10; i++) {
			s[0][i] = 1;//0 레벨의 수는 모두 1로 설정한다
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
		if(level == 0) {//0레벨의 수가 담긴 배열을 가져온다. 참고로 1000000000을 나누라는 문제조건에 따라 수로 나눈 나머지를 리턴한다
			return s[level][num] % 1000000000;
		}else if(s[level][num] != 0) {//수가 기록되있으면 1000000000의 나머지를 리턴한다
			return s[level][num] % 1000000000;
		}else {
			if(num == 0) {//수가 0이라면 다음에 올 수 있는 수는 1뿐이다.
				long n = search(1, level - 1);
				s[level][num] = n;
				return n % 1000000000;
			}else if(num == 9) {//수가 9라면 다음에 올 수 있는 수는 8쁀이다.
				long n = search(8, level - 1);
				s[level][num] = n;
				return n % 1000000000;
			}else {//나머지 숫자는 +1, -1이 올 수 있다.
				long n1 = search(num - 1, level - 1);
				long n2 = search(num + 1, level - 1);
				s[level][num] = n1 + n2;
				return (n1 + n2) % 1000000000;
			}
		}
	}

}
