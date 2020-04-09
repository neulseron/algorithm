

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_5432_쇠막대기자르기 {
	public static String str;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			int answer=0;
			str=br.readLine();
			Stack<Integer> stack=new Stack<Integer>();
			for(int i=0;i<str.length();i++){
				if(str.charAt(i)=='('){
					stack.push(i);
				}else if(str.charAt(i)==')'){
					int start=stack.pop();
					if(start==i-1){
						answer+=stack.size();
					}else{
						answer+=1;
					}
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}//end of main
}//end of class 
