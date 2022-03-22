import java.util.ArrayList;
import java.util.Scanner;

public class LongParticalSequence {
	
	static ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		LongParticalSequence lps = new LongParticalSequence();
		Scanner in = new Scanner(System.in);
		
		int size = in.nextInt();
		int[] arr = new int[size];
		
		for(int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		
		list.add(arr[0]);
		int j = 0;//리스트의 인덱스
		int i = 1;//arr의 인덱스
		
		for(; i < arr.length; i++) {
			if(list.get(j) < arr[i]) {//arr배열의 수가 리스트의 수보다 크면 리스트에 그대로 붙여준다
				list.add(arr[i]);
				j++;
			}else if(list.get(j) > arr[i]){//그렇지 않을 경우에는 갱신할 인덱스는 어디인지 확인한다
				int index = lps.binarySearch(0, j, arr[i]);
				list.set(index, arr[i]);
			}
		}
		
		System.out.println(list.size());
	}
	
	public int binarySearch(int start, int finish, int num) {//이분탐색으로 찾는다면 O(n logn) 시간복잡도로 해결할 수 있다.
		int mid = 0;
		while(start < finish) {
			mid = (start + finish) / 2;
			if(list.get(mid) < num) {
				start = mid + 1;
			}else if(list.get(mid) > num){
				finish = mid;
			}else {
				return mid;
			}
		}
		
		return finish;
	}

}
