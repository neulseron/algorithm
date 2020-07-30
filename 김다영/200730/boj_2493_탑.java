package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2493_탑 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<top> stack = new Stack<>();
		int tmp;
		int idx = 1;
		for(int i = 0; i < N; i++) {
			tmp = Integer.parseInt(st.nextToken().trim());
			if(stack.empty()) {
				stack.push(new top(idx++, tmp));
				sb.append(0).append(" ");
			}
			else {
				while(!stack.empty()) {
					if(tmp <= stack.peek().height) {
						sb.append(stack.peek().idx).append(" ");
						break;
					}
					stack.pop();
				}
				if(stack.empty())
					sb.append(0).append(" ");
				// idx때문에 무조건 넣기는 해야함
				stack.push(new top(idx++,tmp));
			}
		}
		System.out.println(sb);
	}
}

class top{
	int idx;
	int height;
	public top(int idx, int height) {
		this.idx = idx;
		this.height = height;
	}
}