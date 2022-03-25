package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
0을 계산할 때 주의할 점
1. 그냥 0이 나올 경우 0출력
2. 문자열 맨 앞에 0이 나올 경우 0 출력
3. 그 외의 경우에는 두 자리수 (10, 20)를 담기 위해 리스트를 선언해 담는다
4. 문자열을 합쳐볼 때 26이 넘으면 이전에 계산한 값을 그래도 배열에 담고, 그렇지 않으면 이전, 두번째 뒤의 값을 더한다
 */

public class No2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        if(str.length() == 1){//한 자리수는 더 볼것이 없다
            if(str.equals("0")){//0은 0을 출력
                System.out.print(0);
            }else{//그 외에는 경우의 수가 한가지
                System.out.print(1);
            }
            return;
        }

        if(str.charAt(0) == '0'){//맨 앞자리가 0일 경우 해석할 수 없기 때문에 0 출력
            System.out.print(0);
            return;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = str.length() - 1; i >= 0; i--){
            if(str.charAt(i) == '0'){//앞의  숫자까지 추가
                StringBuilder sb = new StringBuilder();
                if(str.charAt(i - 1) == '2' || str.charAt(i - 1) == '1'){//10이나 20은 가능한 경우
                    sb.append(str.charAt(i - 1)).append("0");
                }else{//그렇지 않으면 해독할 수 없는 경우
                    System.out.print("0");
                    return;
                }

                list.add(Integer.parseInt(sb.toString()));//두 자리수라 리스트에 삽입
                i--;//이 때는 다다음 문자를 확인해야 하기 때문에 한번 더 뺀다
            }else{
                list.add(str.charAt(i) - '0');//0이 아니면 숫자를 리스트에 추가
            }
        }

        if(list.size() == 1){//리스트의 길이가 1개로 나올 경우 경우의 수는 1가지
            System.out.print(1);
            return;
        }

        int[] arr = new int[list.size()];
        arr[0] = 1;

        StringBuilder num2 = new StringBuilder();
        num2.append(list.get(1)).append(list.get(0));

        //합쳐봤을 때 해독할 수 없는 문자면 두 번째 공간에 1, 그렇지 않으면 2를 삽입
        if(Integer.parseInt(num2.toString()) <= 26){
            arr[1] = 2;
        }else{
            arr[1] = 1;
        }

        //다음 문자열 까지 더해서 해독할 수 있으면 이전의 2가지 수를 더해 삽입
        //그렇지 않으면 이전에 구한 값을 그대로 삽입
        for(int i = 2; i < list.size(); i++){
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(i)).append(list.get(i - 1));
            if(Integer.parseInt(sb.toString()) <= 26){
                arr[i] = arr[i - 1] + arr[i - 2];
            }else{
                arr[i] = arr[i - 1];
            }

            arr[i] %= 1000000;//문제에서는 1000000의 나머지를 구하라고 명시했기에 작성한 코드드
       }

        System.out.print(arr[list.size() - 1]);
    }
}
