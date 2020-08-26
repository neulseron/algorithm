package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11723_집합_bit {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String str;
		int x, flag = 0;
		int M = Integer.parseInt(br.readLine().trim());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			str = st.nextToken();
			switch(str) {
			case "add":
				x = Integer.parseInt(st.nextToken().trim());
				flag |= (1<<x);
				break;
			case "remove":
				x = Integer.parseInt(st.nextToken().trim());
				flag ^= (1<<x);
				break;
			case "check":
				x = Integer.parseInt(st.nextToken().trim());
				if((flag & (1<<x)) != 0)
						sb.append(1+"\n");
				else
					sb.append(0+"\n");
				break;
			case "toggle":
				x = Integer.parseInt(st.nextToken().trim());
				if((flag & (1<<x)) != 0)
					flag ^= (1<<x);
				else
					flag |= (1<<x);
				break;
			case "all":
				flag = ~0;
				break;
			case "empty":
				flag = 0;
				break;
			default:
				break;
			}
		}
		System.out.println(sb);
	}
}
