import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Possible_Test_Score_3752 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st;
		int T = Integer.parseInt(str);
		int N, max, answer;
		int[] arr;
		boolean[] score;
		int i, j, k;
		for(i = 1; i <= T; i++)
		{
			answer = 1;
			max = 0;
			score = new boolean[10001];
			score[0] = true;
			str = br.readLine();
			N = Integer.parseInt(str);
			arr = new int[N];
			str = br.readLine();
			st = new StringTokenizer(str);
			for(j = 0; j < N; j++)
			{
				arr[j] = Integer.parseInt(st.nextToken());
				max += arr[j];
				for(k = max; k >= 0; k--)
				{
					if(score[k])
					{
						if(!score[k + arr[j]])
						{
							score[k + arr[j]] = true;
							answer += 1;
						}
					}
				}
				//score[max] = true;
			}
//			for(j = 1; j <= max; j++)
//				if(score[j])
//				{
//					System.out.println(j);
//					answer += 1;
//				}
			System.out.println("#" + i + " " + answer);
		}
	}
}