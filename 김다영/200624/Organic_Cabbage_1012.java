package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Organic_Cabbage_1012 extends Node{
	public Organic_Cabbage_1012(int x, int y) {
		super(x, y);
	}

	static int[][] map;
	static boolean[][] visited;
	static int answer, M, N;
	static Queue<Node> que;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int K, X, Y;
		int tc, i;
		for(tc = 0; tc < T; tc++)
		{
			answer = 0;
			que = new LinkedList<Node>();
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[M][N];
			visited = new boolean[M][N];
			for(i = 0; i < K; i++)
			{
				st = new StringTokenizer(br.readLine());
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());
				map[X][Y] = 1;
			}
			Find_Area();
			System.out.println(answer);
		}
	}
	
	private static void Find_Area()
	{
		int i, j;
		for(i = 0; i < M; i++)
		{
			for(j = 0; j < N; j++)
			{
				if(!visited[i][j] && map[i][j] == 1)
				{
					answer++;
					visited[i][j] = true;
					que.add(new Node(i, j));
					BFS();
				}
			}
		}
	}
	
	private static void BFS()
	{
		Node cabbage;
		while(!que.isEmpty())
		{
			cabbage = que.poll();
			int x = cabbage.x;
			int y = cabbage.y;
			int next_x, next_y;
			for(int i = 0; i < 4; i++)
			{
				next_x = x + dx[i];
				next_y = y + dy[i];
				if(Check(next_x, next_y))
				{
					que.add(new Node(next_x, next_y));
					visited[next_x][next_y] = true;
				}
			}
		}
	}
	
	private static boolean Check(int x, int y)
	{
		boolean result = false;
		if(0<= x && x < M && 0 <= y && y < N)
		{
			if(!visited[x][y] && map[x][y] == 1)
				result = true;
		}
		return result;
	}
}