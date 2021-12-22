package Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No16500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int n = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(br.readLine());
        }

        boolean[] dp = new boolean[101];//해당 인덱스 까지의 문자열이 조합으로 가능한지 담은 배열
        dp[0] = true;

        for(int i = 0; i < s.length(); i++){
            int idx = i + 1;//s의 일부 문자열의 길이

            for(int j = 0; j < n; j++){
                String str = list.get(j);//입력받은 n개의 수중 하나
                if(idx >= str.length() && s.startsWith(str, idx - str.length())){//s의 범위 내에 파악가능한지, 범위 내 문자가 str이랑 같은지 확인
                    if(dp[idx - str.length()]){//str길이만큼 뺐을 때 리스트에 포함되는 문자가 있었는지
                        dp[idx] = true;//뺐을 때 문자가 있으면 s의 일부 길이만큼도 리스트의 내용으로 꾸릴 수 있음을 초기화
                        break;
                    }
                }
            }
        }

        if(dp[s.length()]){//가능하면 1
            System.out.println(1);
        }else{//불가능하면 0
            System.out.println(0);
        }
    }
}
