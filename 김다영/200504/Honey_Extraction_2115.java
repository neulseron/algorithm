import java.io.FileInputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Honey_Extraction_2115 {
	static int answer;
	static int N;
	static int M;
	static int C;
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	static ArrayList<Integer> Cal_arr = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_2115.txt"));
		Scanner scan = new Scanner(System.in);
		int TC = scan.nextInt();
		int j, k, s;
		for(int i = 1; i <= TC; i++)
		{
			int cnt = 0;
			answer = 0;
			N = scan.nextInt();
			M = scan.nextInt();
			C = scan.nextInt();
			int[][] amount_arr = new int[N][N];
			for(j = 0; j < N; j++)
				for(k = 0; k < N; k++)
					amount_arr[j][k] = scan.nextInt();
			for(j = 0; j < N; j++)
			{
				for(k = 0; k <= N - M; k++)
				{
					for(s = k; s < k + M; s++)
					{
						arr.add(amount_arr[j][s]);
					}
					Cal_Income();
					arr.clear();
				}
			}
			Find_Max();
			System.out.println("#" + i + " " + answer);
			Cal_arr.clear();
		}
	}
	
	public static void Cal_Income()
	{
		ArrayList<Integer> tmp_arr = new ArrayList<Integer>();
		int tmp = 0;
		int tmp_cal = 0;
		int max = 0;
		int i, j;
		tmp_arr = arr;
		tmp_arr.sort(null);
		Collections.reverse(tmp_arr);
		for(i = 0; i < tmp_arr.size(); i++)
		{
			tmp = 0;
			tmp_cal = 0;
			for(j = i; j < tmp_arr.size(); j++)
			{
				if(tmp_arr.get(j) <= (C - tmp))
				{
					tmp += tmp_arr.get(j);
					tmp_cal += Math.pow(tmp_arr.get(j), 2);
				}
			}
			max = Math.max(max, tmp_cal);
		}
		Cal_arr.add(max);
	}
	
	public static void Find_Max()
	{
		int max = Collections.max(Cal_arr);
		int max_index = Cal_arr.indexOf(max);
		int next_index;
		answer += max;
		Cal_arr.set(max_index, -1);
		while(true)
		{
			max = Collections.max(Cal_arr);
			next_index = Cal_arr.indexOf(max);
			if(max_index / (N - M + 1) != next_index / (N - M + 1))
			{
				answer += max;
				break;
			}
			else if(Math.abs(max_index - next_index) >= M)
			{
				answer += max;
				break;
			}
			else
			{
				Cal_arr.set(next_index, -1);
			}
		}
	}
}