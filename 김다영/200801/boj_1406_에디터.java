package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_1406_에디터 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		Stack<Character> stack1 = new Stack<>(); // 연산이 진행되는 스택
		Stack<Character> stack2 = new Stack<>(); // 'L'이 수행될 때 오른쪽 값을 저장해 둘 스택
		StringTokenizer st;
		char[] c = br.readLine().toCharArray(); // stack1에 char형으로 저장
		int len = c.length;
		for(int i = 0; i < len; i++) {
			stack1.push(c[i]);
		}
		// 데이터 처리
		char ch;
		int M = Integer.parseInt(br.readLine().trim());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			ch = st.nextToken().charAt(0);
			switch(ch) {
			case 'L':
				if(!stack1.empty())
					stack2.push(stack1.pop());
				break;
			case 'D':
				if(!stack2.empty())
					stack1.push(stack2.pop());
				break;
			case 'B':
				if(!stack1.empty())
					stack1.pop();
				break;
			case 'P':
				stack1.push(st.nextToken().charAt(0));
				break;
			}
		}
		// 출력
		StringBuilder sb = new StringBuilder();
		int size = stack1.size();
		for(int i = 0; i < size; i++)
			stack2.push(stack1.pop());
		size = stack2.size();
		for(int i = 0; i < size; i++)
			sb.append(stack2.pop());
		System.out.println(sb);
	}
}