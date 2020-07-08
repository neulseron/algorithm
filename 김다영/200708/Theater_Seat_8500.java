import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Theater_Seat_8500 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int N, i, answer;
		int[] arr;
		for(int tc = 1; tc <= T; tc++)
		{
			N = Integer.parseInt(br.readLine());
			answer = N;
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			for(i = 0; i < N; i++)
				answer += arr[i];
			answer += arr[N - 1];
			System.out.println("#" + tc + " " + answer);
		}
	}
}