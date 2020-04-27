import java.io.FileInputStream;
import java.util.Scanner;
public class Chef_4012 {
	static int N;
	static int[][] Synergy;
	static boolean[] visited;
	static int min;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_4012.txt"));
		Scanner scan = new Scanner(System.in);
		int TC = scan.nextInt();
		int j,k;
		for(int i = 1; i <= TC; i++)
		{
			N = scan.nextInt();
			Synergy = new int[N][N];
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			for(j = 0; j < N; j++)
			{
				for(k = 0; k < N; k++)
				{
					Synergy[j][k] = scan.nextInt();
				}
			}
			visited[0] = true;
			dfs(1, 1);
			System.out.println("#" + i + " " + min);
		}
	}
	public static void dfs(int start, int cnt)
	{
		int i, j, A_sum = 0, B_sum = 0, tmp;
		if(cnt == N/2)
		{
			for(i = 0; i < N; i++)
			{
				if(visited[i])
				{
					for(j = i + 1; j < N; j++)
					{
						if(visited[j])
						{
							A_sum += Synergy[i][j];
							A_sum += Synergy[j][i];
						}
					}
				}
				else
				{
					for(j = i + 1; j < N; j++)
					{
						if(!visited[j])
						{
							B_sum += Synergy[i][j];
							B_sum += Synergy[j][i];
						}
					}
				}
			}
			tmp = Math.abs(A_sum - B_sum);
			min = Math.min(min, tmp);
			return;
		}
		for(i = start; i < N; i++)
		{
			visited[i] = true;
			dfs(i + 1, cnt + 1);
			visited[i] = false;
		}
	}
}