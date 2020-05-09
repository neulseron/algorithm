package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Black_Jack_2798 {
	static int N;
	static int[] arr;
	static int M;
	static int min;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		StringTokenizer st = new StringTokenizer(tmp);
		min = Integer.MAX_VALUE;
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		M = Integer.parseInt(st.nextToken());
		int i;
		tmp = br.readLine();
		st = new StringTokenizer(tmp);
		for(i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Solve();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(Integer.toString(min));
		br.close();
		bw.close();
	}
	
	public static void Solve()
	{
		int a, b ,c;
		int i, j, k;
		int sum;
		for(i = 0; i < N - 1; i++)
		{
			a = arr[i];
			for(j = i + 1; j < N - 1; j++)
			{
				b = arr[j];
				for(k = j + 1; k < N; k++)
				{
					c = arr[k];
					sum = a + b + c;
					if(M == sum)
					{
						min = M;
						return;
					}
					else if(M > sum)
					{
						if(Math.abs(M - sum) < Math.abs(M - min))
							min = sum;
					}
				}
			}
		}
	}
}