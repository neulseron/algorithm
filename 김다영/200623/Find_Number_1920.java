package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Find_Number_1920 {
	static int[] N_arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int i, num, answer;
		st = new StringTokenizer(br.readLine());
		N_arr = new int[N];
		for(i = 0; i < N; i++)
			N_arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(N_arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int min = N_arr[0];
		int max = N_arr[N - 1];
		for(i = 0; i < M; i++)
		{
			answer = 0;
			num = Integer.parseInt(st.nextToken());
			if(min <= num && num <= max)
				answer = Solve(0, N - 1, num);
			bw.write(Integer.toString(answer) + "\n");
		}
		bw.close();
	}
	
	private static int Solve(int min_idx, int max_idx, int num)
	{
		int mid;
		while(min_idx <= max_idx)
		{
			mid = (min_idx + max_idx) / 2;
			if(num == N_arr[mid])
				return 1;
			else if(num < N_arr[mid])
				max_idx = mid - 1;
			else
				min_idx = mid + 1;
		}
		return 0;
	}
}