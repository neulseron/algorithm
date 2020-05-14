package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Complex_Number_2667 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		ArrayList<Node> bfs;
		ArrayList<Integer> answer = new ArrayList<Integer>();
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int cnt;
		int x, y;
		int i, j, k;
		for(i = 0 ; i < N; i++)
		{
			str = br.readLine();
			for(j = 0 ; j < N; j++)
			{
				arr[i][j] = str.charAt(j) - 48;
			}
		}
		for(i = 0 ; i < N; i++)
		{
			for(j = 0 ; j < N; j++)
			{
				if(visited[i][j] == true)
					continue;
				if(arr[i][j] == 0)
				{
					visited[i][j] = true;
					continue;
				}
				else
				{
					bfs = new ArrayList<Node>();
					bfs.add(new Node(i, j));
					cnt = 1;
					visited[i][j] = true;
					while(!bfs.isEmpty())
					{
						x = bfs.get(0).x;
						y = bfs.get(0).y;
						for(k = 0;  k < 4; k++)
						{
							int next_x = x + dx[k];
							int next_y = y + dy[k];
							if(next_x < 0 || next_y < 0 || next_x >= N || next_y >= N || visited[next_x][next_y] == true)
								continue;
							if(arr[next_x][next_y] == 1)
							{
								visited[next_x][next_y] = true;
								bfs.add(new Node(next_x, next_y));
								cnt++;
							}
						}
						bfs.remove(0);
					}
					answer.add(cnt);
				}
			}
		}
		answer.sort(null);
		System.out.println(answer.size());
		for(i = 0; i < answer.size(); i++)
			System.out.println(answer.get(i));
	}
}
class Node{
	int x;
	int y;
	public Node(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}