package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2231_분해합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int tmp;
		String str;
		for(int i = 1; i <= N; i++) {
			str = Integer.toString(i);
			tmp = i;
			for(int j = 0; j < str.length(); j++)
				tmp += (str.charAt(j) - '0');
			if(tmp == N) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
}
