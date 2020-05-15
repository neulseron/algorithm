package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Easy_Stair_Number_another_solution_10844 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		long[] arr1 = {1,1,1,1,1,1,1,1,1};
		long[] arr2 = {2,2,2,2,2,2,2,2,1};
		long[] arr3 = new long[9];
		int N = Integer.parseInt(str);
		int i;
		long answer = 0;
		if(N == 1)
		{
			for(i = 0; i < 9; i++)
				answer += arr1[i];
		}
		else if(N == 2)
		{
			for(i = 0; i < 9; i++)
				answer += arr2[i];
		}
		else
		{
			for(i = 2; i < N; i++)
			{
				arr3[7] = arr3[0] = (arr1[7] + arr2[6])%1000000000;
				arr3[6] = arr3[1] = (arr2[7] + arr2[5])%1000000000;
				arr3[5] = arr3[2] = (arr2[6] + arr2[4])%1000000000;
				arr3[4] = arr3[3] = (arr2[5] + arr2[3])%1000000000;
				arr3[8] = arr2[7];
				System.arraycopy(arr2, 0, arr1, 0, 9);
				System.arraycopy(arr3, 0, arr2, 0, 9);
			}
			for(i = 0; i < 9; i++)
				answer = (answer + arr3[i])%1000000000;
		}
		System.out.println(answer);
	}
}