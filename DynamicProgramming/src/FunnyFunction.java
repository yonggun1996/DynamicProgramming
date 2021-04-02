import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FunnyFunction {
	
	static HashMap<String, Integer> map = new HashMap<String, Integer>();

	public static void main(String[] args) throws IOException {
		FunnyFunction ff = new FunnyFunction();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int num3 = Integer.parseInt(st.nextToken());
			
			if(num1 == -1 && num2 == -1 && num3 == -1) {
				break;
			}
			
			bw.write("w(" + num1 + ", " + num2 + ", " + num3 + " = " + ff.w(num1, num2, num3));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}//main
	
	public int w(int a,int b,int c) {
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}else if(a > 20 || b > 20 || c > 20) {
			return w(20,20,20);
		}else if(a < b && b < c) {
			int num1 = 0;
			int num2 = 0;
			int num3 = 0;
			
			String key = "" + a + "/" + b + "/" + c;
			if(map.containsKey(key)) {
				int value = map.get(key);
				return value;
			}else {
				num1 = w(a,b,c-1);
				num2 = w(a,b-1,c-1);
				num3 = w(a,b-1,c);
				map.put(key, num1 + num2 - num3);
				
				return num1 + num2 - num3;
			}
		}else {
			int num1 = 0;
			int num2 = 0;
			int num3 = 0;
			int num4 = 0;
			
			String key = "" + a + "/" + b + "/" + c;
			
			if(map.containsKey(key)) {
				int value = map.get(key);
				return value;
			}else {
				num1 = w(a-1,b,c);
				num2 = w(a-1,b-1,c);
				num3 = w(a-1,b,c-1);
				num4 = w(a-1, b-1, c-1);
				map.put(key, num1 + num2 + num3 - num4);
				
				return num1 + num2 + num3 - num4;
			}
		}
	}

}
