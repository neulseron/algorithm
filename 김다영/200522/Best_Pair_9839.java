import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Best_Pair_9839 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st;
		int TC = Integer.parseInt(str);
		int N;
		Integer[] arr;
		int i, j, k;
		int check, answer, tmp = 0;
		for(i = 1; i <= TC; i++)
		{
			answer = 0;
			check = 0;
			N = Integer.parseInt(br.readLine());
			arr = new Integer[N];
			str = br.readLine();
			st = new StringTokenizer(str);
			for(j = 0; j < N; j++)		
				arr[j] = Integer.parseInt(st.nextToken());
			//Arrays.sort(arr, Collections.reverseOrder());
			for(j = 0; j < N - 1; j++)
			{
				for(k = j + 1; k < N; k++)
				{
					tmp = arr[j] * arr[k];
					check = Check(tmp);
					if(check == 1)
						answer = Math.max(answer, tmp);
				}
			}
			if(answer == 0)
				answer = -1;
			System.out.println("#" + i + " " + answer);
		}
	}
	
	public static int Check(int tmp)
	{
		int check = 1;
		String tmp_s = Integer.toString(tmp);
		int tmp_i = tmp_s.charAt(0) - 48;
		for(int i = 1; i < tmp_s.length(); i++)
		{
			if(tmp_i + 1 == tmp_s.charAt(i) - 48)
				tmp_i = tmp_s.charAt(i) - 48;
			else
			{
				check = 0;
				break;
			}
		}
		return check;
	}
}