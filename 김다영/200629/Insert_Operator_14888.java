package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Insert_Operator_14888 {
	static int[] num;
	static int N;
	static int min, max;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		int[] operator = new int[4]; // +, -, *, /
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		int cnt = 0, answer;
		int i;
		st = new StringTokenizer(br.readLine());
		for(i = 0; i < N; i++)
			num[i] = Integer.parseInt(st.nextToken());
		answer = num[0];
		
		st = new StringTokenizer(br.readLine());
		for(i = 0; i < 4; i++)
			operator[i] = Integer.parseInt(st.nextToken());
		
		Solve(operator, cnt, answer);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	private static void Solve(int[] operator, int cnt, int answer)
	{
		if(cnt == N - 1)
		{
			min = Math.min(answer, min);
			max = Math.max(answer, max);
			return;
		}
		if(operator[0] != 0) // '+'
		{
			operator[0] -= 1;
			cnt += 1;
			Solve(operator, cnt, answer + num[cnt]);
			cnt -= 1;
			operator[0] += 1;
		}
		if(operator[1] != 0) // '-'
		{
			operator[1] -= 1;
			cnt += 1;
			Solve(operator, cnt, answer - num[cnt]);
			cnt -= 1;
			operator[1] += 1;
		}
		if(operator[2] != 0) // '*'
		{
			operator[2] -= 1;
			cnt += 1;
			Solve(operator, cnt, answer * num[cnt]);
			cnt -= 1;
			operator[2] += 1;
		}
		if(operator[3] != 0) // '/'
		{
			operator[3] -= 1;
			cnt += 1;
			Solve(operator, cnt, answer / num[cnt]);
			cnt -= 1;
			operator[3] += 1;
		}
	}
}