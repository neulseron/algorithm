package programming.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1233_사칙연산_유효성검사 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		char ch;
		int result;
		for(int tc = 1; tc <= 10; tc++) {
			sb.append("#"+tc+" ");
			int N = Integer.parseInt(br.readLine());
			result = 1;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				if(result == 0)
					continue;
				if(st.countTokens() == 4) {
					st.nextToken();
					ch = st.nextToken().charAt(0);
					if(ch == '-' || ch == '+' || ch == '*' || ch == '/') {
						continue;
					}else {
						result = 0;
					}
				}else if(st.countTokens() == 2) {
					st.nextToken();
					ch = st.nextToken().charAt(0);
					if(ch == '-' || ch == '+' || ch == '*' || ch == '/') {
						result = 0;
					}
				}
			}
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}
}
