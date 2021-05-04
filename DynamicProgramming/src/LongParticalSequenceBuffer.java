import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LongParticalSequenceBuffer {
	
	static ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		LongParticalSequenceBuffer lps = new LongParticalSequenceBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];
		
		StringTokenizer st = null;
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
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
		
		bw.write(String.valueOf(list.size()));
		bw.flush();
		bw.close();
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
