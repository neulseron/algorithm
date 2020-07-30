package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ucpc_15904{
	
    public static void main(String[] args) throws Exception{
        char[] ucpc = {'U', 'C', 'P', 'C'};
        int idx = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ucpc[idx]){
                ++idx;
                if(idx == 4){
                    System.out.println("I love UCPC");
                    return;
                }
            }
        }
        System.out.println("I hate UCPC");
    }
}