package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class stack_10828 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<Integer>();
        int  N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                	System.out.println(stack.empty()?-1:stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                	System.out.println(stack.empty()?1:0);
                    break;
                case "top":
                	System.out.println(stack.empty()?-1:stack.peek());
                    break;
                default:
                	break;
            }
        }
	}
}