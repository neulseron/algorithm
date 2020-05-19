package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Age_Sort_10814 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str);
		StringTokenizer st;
		String[][] arr = new String[N][2];
		int i, j;
		for(i = 0; i < N; i++)
		{
			str = br.readLine();
			st = new StringTokenizer(str);
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
		}
		Arrays.sort(arr, (o1, o2)->{
			return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
		});
		for(i = 0; i < N; i++)
			System.out.println(arr[i][0] + " " + arr[i][1]);
	}
}