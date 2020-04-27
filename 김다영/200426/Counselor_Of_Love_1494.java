import java.io.FileInputStream;
import java.util.Scanner;
public class Counselor_Of_Love_1494 {
	static int [][] arr;
	static boolean[] visited;
	static int N;
	static long answer, x_sum, y_sum;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_1494.txt"));
		Scanner scan = new Scanner(System.in);
		int TC = scan.nextInt();
		int j;
		for(int i = 1; i <= TC; i++)
		{
			answer = Long.MAX_VALUE;
			N = scan.nextInt();
			arr = new int[N][2];
			visited = new boolean[N];
			x_sum = 0;
			y_sum = 0;
			for(j = 0; j < N; j++)
			{
				arr[j][0] = scan.nextInt();
				x_sum += arr[j][0];
				arr[j][1] = scan.nextInt();
				y_sum += arr[j][1];
			}
            visited[0] = true;
			dfs(1,1);
			System.out.println("#" + i + " " + answer);
		}
	}
	
	public static void dfs(int start, int cnt) {
		int i;
		long x = 0, y = 0, sum = 0;
		if(cnt == N/2)
		{
			for(i = 0; i < N; i++)
			{
				if(visited[i])
				{
					x += arr[i][0];
					y += arr[i][1];
				}
			}
			sum = (long)Math.pow(2*x - x_sum, 2) + (long)Math.pow(2*y - y_sum, 2);
			if(answer > sum)
				answer = sum;
			return;
		}
		for(i = start; i < N; i++)
		{
			if(!visited[i])
			{
				visited[i] = true;
				dfs(i + 1,cnt+1);
				visited[i] = false;
			}
		}
	}
}