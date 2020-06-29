package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Multiplication_1629 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		System.out.println(Solve(A % C, B, C));
	}
	
	private static long Solve(long a, long b, long c)
	{
		if(b == 1)
			return a;
		long result = Solve(a, b/2, c) % c;
		result = (result * result) % c;
		if(b % 2 == 0)
			return result;
		else
			return (result * a) % c;
	}
}