import java.util.Scanner;

public class LCS {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String str1 = in.next();
		String str2 = in.next();
		
		int[][] arr = new int[str1.length() + 1][str2.length() + 1];
		
		for(int i = 1; i <= str1.length(); i++) {
			for(int j = 1; j <= str2.length(); j++) {
				if(str1.charAt(i - 1) == str2.charAt(j - 1)) {//문자가 같을 경우 한 글자씩 뺀 결과에 1을 더해 저장한다
					arr[i][j] = arr[i - 1][j - 1] + 1;
				}else {//그렇지 않을 경우 왼쪽이나 상단에 값 중 더 큰 값을 저장한다
					int num1 = arr[i - 1][j];
					int num2 = arr[i][j - 1];
					
					if(num1 > num2) {
						arr[i][j] = num1;
					}else {
						arr[i][j] = num2;
					}
				}
			}
		}
		
		System.out.println(arr[str1.length()][str2.length()]);
	}

}
