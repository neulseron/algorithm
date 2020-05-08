package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Sort_3_10989 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] cnt = new int[10001];
		int max = 0;
		int N = Integer.parseInt(br.readLine());
		int i, j, tmp;
		for(i = 0; i < N; i++)
		{
			tmp = Integer.parseInt(br.readLine());
			cnt[tmp] += 1;
			if(max < tmp)
				max = tmp;
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(i = 1; i <= max; i++)
		{
			if(cnt[i] == 0)
				continue;
			for(j = 0; j < cnt[i]; j++)
				bw.write(i + "\n");
		}
		br.close();
		bw.close();
	}
}