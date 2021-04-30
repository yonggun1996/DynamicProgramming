import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class WineBuffer {
	
	static int[] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size + 1];
		map = new int[size + 1];
		
		StringTokenizer st = null;
		for(int i = 1; i <= size; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(size >= 1) {
			map[1] = arr[1];
		}
		
		if(size >= 2) {
			map[2] = arr[1] + arr[2];
		}
		
		if(size <= 2) {
			System.out.println(map[size]);
		}else {
			for(int i = 3; i <= size; i++) {
				int num1 = map[i - 1];
				int num2 = map[i - 2] + arr[i];
				int num3 = map[i - 3] + arr[i - 1] + arr[i];
			
				int max = Math.max(Math.max(num1, num2), num3);
				map[i] = max;
			}
			bw.write(String.valueOf(map[size]));
			bw.flush();
		}
		
	}
	
}
