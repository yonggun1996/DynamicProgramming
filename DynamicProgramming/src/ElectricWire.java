import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ElectricWire {
	
	static ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		ElectricWire ew = new ElectricWire();
		Scanner in = new Scanner(System.in);
		
		int size = in.nextInt();
		int[][] arr = new int[size][2];
		
		for(int i = 0; i < size; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
		}
		
		//[i][0]번째를 기준으로 2차원 배열을 정렬을 한 후 [i][1]번째 수를 기준으로 배열을 만든다
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}else {
					return o1[0] - o2[0];
				}
			}
		});
		list.add(arr[0][1]);
		
		int j = 0;
		for(int i = 1; i < size; i++) {
			if(list.get(j) < arr[i][1]) {//arr[i][1]가 크면 리스트에 계속 붙여준다
				list.add(arr[i][1]);
				j++;
			}else {
				int index = ew.binarySearch(0, j, arr[i][1]);
				list.set(index, arr[i][1]);
			}
		}
		
		System.out.println(size - list.size());//입력받은 사이즈와 이어진 배열의 개수를 빼면 빼야할 전신줄의 갯수가 나옵니다.
	}
	
	public int binarySearch(int start, int finish, int num) {//갱신할 위치를 찾는 메소드
		while(start < finish) {
			int mid = (start + finish) / 2;
			
			if(list.get(mid) > num) {
				finish = mid;
			}else if(list.get(mid) < num) {
				start = mid + 1;
			}else {
				return mid;
			}
		}
		
		return finish;
	}

}
