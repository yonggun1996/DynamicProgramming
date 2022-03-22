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
		int j = 0;//����Ʈ�� �ε���
		int i = 1;//arr�� �ε���
		
		for(; i < arr.length; i++) {
			if(list.get(j) < arr[i]) {//arr�迭�� ���� ����Ʈ�� ������ ũ�� ����Ʈ�� �״�� �ٿ��ش�
				list.add(arr[i]);
				j++;
			}else if(list.get(j) > arr[i]){//�׷��� ���� ��쿡�� ������ �ε����� ������� Ȯ���Ѵ�
				int index = lps.binarySearch(0, j, arr[i]);
				list.set(index, arr[i]);
			}
		}
		
		System.out.println(list.size());
	}
	
	public int binarySearch(int start, int finish, int num) {//�̺�Ž������ ã�´ٸ� O(n logn) �ð����⵵�� �ذ��� �� �ִ�.
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
