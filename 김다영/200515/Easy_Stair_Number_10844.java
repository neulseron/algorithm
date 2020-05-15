package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Easy_Stair_Number_10844 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str);
		int[][] arr = new int[N][10];
		int i, j;
		long answer = 0;
		for(i = 1; i < 10; i++)
			arr[0][i] = 1;
		for(i = 1; i < N; i++)
		{
			arr[i][0] = arr[i - 1][1];
			for(j = 1; j < 9; j++)
				arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % 1000000000;
			arr[i][9] = arr[i - 1][8];
		}
		for(i = 0; i < 10; i++)
			answer = (answer + arr[N - 1][i]) % 1000000000;
		System.out.println(answer);
	}
}