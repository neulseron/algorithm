package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_11723_집합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String str;
		int x;
		int M = Integer.parseInt(br.readLine().trim());
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			str = st.nextToken();
			switch(str) {
			case "add":
				x = Integer.parseInt(st.nextToken().trim());
				set.add(x);
				break;
			case "remove":
				x = Integer.parseInt(st.nextToken().trim());
				set.remove(x);
				break;
			case "check":
				x = Integer.parseInt(st.nextToken().trim());
				if(set.contains(x))
					sb.append(1+"\n");
				else
					sb.append(0+"\n");
				break;
			case "toggle":
				x = Integer.parseInt(st.nextToken().trim());
				if(!set.remove(x))
					set.add(x);
				break;
			case "all":
				set.clear();
				for(int j = 1; j <=20; j++)
					set.add(j);
				break;
			case "empty":
				set.clear();
				break;
			default:
				break;
			}
		}
		System.out.println(sb);
	}

}
