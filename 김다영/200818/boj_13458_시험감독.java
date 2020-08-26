package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13458_시험감독 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int A, B, C;
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st1.nextToken().trim());
		C = Integer.parseInt(st1.nextToken().trim());
		long answer = 0;
		for(int i = 0; i < N; i++) {
			A = Integer.parseInt(st.nextToken().trim());
			answer += 1;
			A -= B;
			if(A <= 0)
				continue;
			else {
				answer += A/C;
				if(A % C != 0)
					answer += 1;
			}
		}
		System.out.println(answer);
		
	}

}
