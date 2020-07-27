package programming.baekjoon;

import java.util.Scanner;

public class ironBar_10799 {

	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		String parenthesis = scan.next();
		int first_cnt = 0; // '('의 개수
		char cur_char = ' '; // 현재 문자
		char pre_char = ' '; // 이전 문자
		int answer = 0;
		int len = parenthesis.length();
		
		for(int i = 0; i < len - 1; i++) {
			cur_char = parenthesis.charAt(i);
			if(cur_char == '(') { // '('라면 fisrt_cnt 증가
				++first_cnt;
			}
			else if(cur_char == ')') { 
				--first_cnt;
				if(pre_char == '(') { // 레이저라면
					answer += first_cnt;
				}
				else if(pre_char == ')') { // 레이저가 아닌 막대기의 끝이기 때문에 +1
					answer += 1;
				}
			}
			pre_char = cur_char;
		}
		if(pre_char == ')')
			answer += 1;
		System.out.println(answer);
	}
}
