import java.io.FileInputStream;
import java.util.Scanner;
public class Crop_Harvesting_2805 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_2805.txt"));
		Scanner scan = new Scanner(System.in);
		int TC = scan.nextInt();
		int i, j, k;
		int N, index, cnt, answer;
		int[][] arr;
		String str;
		for(i = 1; i <= TC; i++)
		{
			answer = 0;
			N = scan.nextInt();
			arr = new int[N][N];
			for(j = 0; j < N; j++)
			{
				str = scan.next();
				for(k = 0; k < N; k++)
					arr[j][k] = str.charAt(k) - '0';
			}
			index = N/2;
			cnt = 1;
			for(j = 0; j  < index; j++)
			{
				for(k = 0; k < cnt; k++)
					answer += arr[j][index - j + k];
				cnt += 2;
			}
			cnt = N;
			for(j = 0; j <= index; j++)
			{
				for(k = 0; k < cnt; k++)
					answer += arr[j + index][j + k];
				cnt -= 2;
			}
			System.out.println("#" + i + " " + answer);
		}
	}
}