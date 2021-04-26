import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MakeOneBuffer {
	
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		arr = new int[num + 1];
		arr[1] = 0;
		
		for(int i = 2; i <=num; i++) {
			int n = search(i, 0);
			arr[i] = n;
		}
		
		
		bw.write(String.valueOf(arr[num]));
		bw.flush();
		bw.close();
	}
	
	public static int search(int num, int depth) {
		if(num == 1) {
			return depth;
		}else if(arr[num] != 0) {
			return arr[num] + depth;
		}else {
			int num1 = search(num - 1, depth + 1);
			
			int num2 = 2147483647;
			if(num % 2 == 0) {
				num2 = search(num / 2, depth + 1);
			}
			
			int num3 = 2147483647;
			if(num % 3 == 0) {
				num3 = search(num / 3, depth + 1);
			}
			
			int min = 0;
			if(num1 <= num2 && num1 <= num3) {
				min = num1;
			}else if(num2 <= num1 && num2 <= num3) {
				min = num2;
			}else if(num3 <= num1 && num3 <= num2) {
				min = num3;
			}
			
			return min;
		}
	}

}