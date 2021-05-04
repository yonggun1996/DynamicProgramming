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
			if(list.get(j) < arr[i][1]) {
				list.add(arr[i][1]);
				j++;
			}else {
				int index = ew.binarySearch(0, j, arr[i][1]);
				list.set(index, arr[i][1]);
			}
		}
		
		System.out.println(size - list.size());
	}
	
	public int binarySearch(int start, int finish, int num) {
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
