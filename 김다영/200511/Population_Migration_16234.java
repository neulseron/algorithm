package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Population_Migration_16234 {
	static boolean[][] visited;
	static int N, L, R;
	static int[][] arr;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int pre_num, sum = 0, avg;
	static ArrayList<ArrayList<Integer>> bfs;
	static ArrayList<ArrayList<Integer>> tmp_arr;
	static ArrayList<Integer> tmp;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp_s = br.readLine();
		StringTokenizer st = new StringTokenizer(tmp_s);
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		int answer = 0;
		int i, j, k, s;
		for(i = 0; i < N; i++)
		{
			tmp_s = br.readLine();
			st = new StringTokenizer(tmp_s);
			for(j = 0; j < N ; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		while(true)
		{
			visited = new boolean[N][N];
			if(!check())
				answer++;
			else
				break;
		}
		System.out.println(answer);
	}
	
	static boolean check()
	{
		boolean stop = true;
		int i, j, k;
		for(i = 0; i < N; i ++)
		{
			for(j = 0 ; j < N ; j++)
			{
				if(visited[i][j] == true)
					continue;
				tmp = new ArrayList<Integer>();
				tmp_arr = new ArrayList<ArrayList<Integer>>();
				bfs = new ArrayList<ArrayList<Integer>>();
				tmp.add(i);
				tmp.add(j);
				bfs.add(tmp);
				tmp_arr.add(tmp);
				visited[i][j] = true;
				Solve();
				if(tmp_arr.size() != 1) // 인구 이동이 일어남
				{
					stop = false;
					Cal();
				}
			}
		}
		return stop;
	}
	
	static void Solve()
	{
		int k;
		sum = 0;
		while(!bfs.isEmpty())
		{
			int pre_x = bfs.get(0).get(0);
			int pre_y = bfs.get(0).get(1);
			pre_num = arr[pre_x][pre_y];
			sum  += pre_num;
			for(k = 0; k < 4; k++)
			{
				int x = pre_x + dx[k];
				int y = pre_y + dy[k];
				if(0 <= x && x < N && 0 <= y && y < N)
				{
					if(!visited[x][y])
					{
						int sub = Math.abs(pre_num - arr[x][y]);
						if(L <= sub && sub <= R)
						{
							visited[x][y] = true;
							tmp = new ArrayList<Integer>();
							tmp.add(x);
							tmp.add(y);
							bfs.add(tmp);
							tmp_arr.add(tmp);
						}
					}
				}
			}
			bfs.remove(0);
		}
	}
	
	static void Cal()
	{
		int k;
		avg = sum/tmp_arr.size();
		for(k = 0; k < tmp_arr.size(); k++)
		{
			arr[tmp_arr.get(k).get(0)][tmp_arr.get(k).get(1)] = avg;
		}
	}
}