import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class Escaped_Prisoner_1953 {
	static int[][] direction_rule = {{0, 1, 2, 3}, {0, 2, -1, -1}, {1, 3, -1, -1}, 
			{0, 1, -1, -1}, {1, 2, -1, -1}, {2, 3, -1, -1}, {0, 3, -1, -1}}; // 0 : 상, 1 : 우, 2 : 하, 3 : 좌
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, M, R, C, L; // N : 세로, M : 가로, R : 맨홀 세로 위치, C : 맨홀 가로 위치, L : 이동시간
	static int[][] Tunnel_arr;
	static boolean[][] visited;
	static ArrayList<ArrayList<Integer>> tmp_list;
	static ArrayList<Integer> xy;
	static int x, y;
	static int answer;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_1953.txt"));
		Scanner scan = new Scanner(System.in);
		int TC = scan.nextInt();
		int j, k;
		for(int i = 1; i <= TC; i++)
		{
			tmp_list = new ArrayList<ArrayList<Integer>>();
			xy = new ArrayList<Integer>();
			answer = 1;
			N = scan.nextInt();
			M = scan.nextInt();
			R = scan.nextInt();
			C = scan.nextInt();
			L = scan.nextInt();
			Tunnel_arr = new int[N][M];
			visited = new boolean[N][M];
			for(j = 0; j < N; j++)
				for(k = 0; k < M; k++)
					Tunnel_arr[j][k] = scan.nextInt();
			visited[R][C] = true;
			x = R;
			y = C;
			xy.add(x);
			xy.add(y);
			tmp_list.add(xy);
			Count();
			System.out.println("#" + i + " " + answer);
		}
	}
	
	public static void Count()
	{
		int idx, j, k, s, check = 0, tmp, info, length;
		for(idx = 1; idx < L; idx++)
		{
			length = tmp_list.size();
			for(s = 0; s < length; s++)
			{
				x = tmp_list.get(0).get(0);
				y = tmp_list.get(0).get(1);
				info = Tunnel_arr[x][y];
				tmp_list.remove(0);
				for(j = 0; j < 4; j++)
				{
					check = 0;
					if(direction_rule[info - 1][j] == -1)
						break;
					x += dx[direction_rule[info - 1][j]];
					y += dy[direction_rule[info - 1][j]];
					if(0 <= x && x <= N - 1 && 0 <= y && y <= M - 1)
					{
						if(visited[x][y] == false && Tunnel_arr[x][y] != 0)
						{
							if(direction_rule[info - 1][j] < 2)
								tmp = direction_rule[info - 1][j] + 2;
							else
								tmp = direction_rule[info - 1][j] - 2;
							for(k = 0; k < 4; k++)
								if(direction_rule[Tunnel_arr[x][y] - 1][k] == tmp)
								{
									check = 1;
									break;
								}
							if(check == 0)
							{
								x -= dx[direction_rule[info - 1][j]];
								y -= dy[direction_rule[info - 1][j]];
								continue;
							}
							visited[x][y] = true;
							answer += 1;
							xy = new ArrayList<Integer>();
							xy.add(x);
							xy.add(y);
							tmp_list.add(xy);
						}
					}
					x -= dx[direction_rule[info - 1][j]];
					y -= dy[direction_rule[info - 1][j]];
				}
			}
		}
	}
}