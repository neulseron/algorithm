package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class KAKAO_괄호변환 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String p=br.readLine();
		String answer=solution(p);
		System.out.println(answer);
	}//end of main

	private static String solution(String p) {
		return divide(p);
	}

	private static boolean check(String p) {
		Stack<Character> stack =new Stack<>();
		for(int i=0;i<p.length();i++) {
			if(p.charAt(i)=='(') stack.push(p.charAt(i));
			else if(p.charAt(i)==')') {
				if(!stack.isEmpty()) {
					stack.pop();
				}else {
					return false;
				}
			}
		}
		if(!stack.isEmpty())
			return false;
		return true;
	}

	private static String divide(String p) {
		String answer="";
		if(p=="")
			return p;
		//올바른 문자열인지 검사
		if(check(p)) {
			return p;
		}
		else {
			//u,v로 나누기 
			int leftCnt=0;
			int rightCnt=0;
			int idx=0;
			int len=p.length();
			for(int i=0;i<len;i++) {
				if(p.charAt(i)=='(') leftCnt++;
				else if(p.charAt(i)==')') rightCnt++;
				if(leftCnt==rightCnt) {
					idx=i;
					break;
				}
			}
			String u="";
			String v="";
			if(idx==len-1) {
				u=p;
			}else {
				u=p.substring(0,idx+1);
				v=p.substring(idx+1,len);				
			}
			//u가 올바른 문자열인지 검사
			if(check(u)) {
				//올바르다면  divide(v);
				answer=u+divide(v);
			}else {
				//아니라면, '(' + divide(v) +')' + u 문자열 처리 (앞뒤 없애고 나머지 방향 반대로)			
				int uLen=u.length();
				String tmp=u.substring(1, uLen-1);
				String newU="";
				for(int i=0;i<tmp.length();i++) {
					if(tmp.charAt(i)=='(') newU+=')';
					else if(tmp.charAt(i)==')') newU+='(';
				}
				answer='('+divide(v)+')'+newU;
			}
		}
		return answer;
	}
	
}//end of class 
