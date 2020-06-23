package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACM_Craft_1005 {
	static int[] time;
	static int[] dp;
	static int[] degree;
	static boolean[][] graph;
	static Queue<Integer> tmp_seq;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc, i;
		int K, X, Y, W;
		int T = Integer.parseInt(br.readLine());
		for(tc = 0; tc < T; tc++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			time = new int[N];
			dp = new int[N];
			degree = new int[N];
			graph = new boolean[N][N];
			tmp_seq = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine());
			for(i = 0; i < N; i++)
				time[i] = Integer.parseInt(st.nextToken());
			dp[0] = time[0];
			for(i = 0; i < K; i++)
			{
				st = new StringTokenizer(br.readLine());
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());
				degree[Y - 1]++;
				graph[X - 1][Y - 1] = true;
			}
			Topology_Sort();
			W = Integer.parseInt(br.readLine());
			System.out.println(dp[W - 1]);
		}
	}
	
	private static void Topology_Sort()
	{
		int i;
		for(i = 0; i < N; i++)
		{
			if(degree[i] == 0)
			{
				tmp_seq.add(i);
				dp[i] = time[i];
			}
		}
		while(!tmp_seq.isEmpty())
		{
			int num = tmp_seq.poll();
			for(i = 0; i < N; i++)
			{
				if(graph[num][i])
				{
					dp[i] = Math.max(dp[i], dp[num] + time[i]);
					if(--degree[i] == 0)
						tmp_seq.add(i);
				}
			}
		}
	}
}