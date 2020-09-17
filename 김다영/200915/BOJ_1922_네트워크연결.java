package baekjoon.no_1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1922_네트워크연결 {
	static int[] parent;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine().trim());
		int M = Integer.parseInt(br.readLine().trim());
		int f,t,w, ff, ft, answer = 0;
		Edge[] list = new Edge[M];
		parent = new int[N+1];
		// 데이터 입력
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			f = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			list[i] = new Edge(f,t,w);
		}
		Arrays.sort(list);
		// Make Set
		for(int i = 1; i <= N; i++)
			parent[i] = i;
		// 연결 수행
		for(int i = 0; i < M; i++) {
			f = list[i].from;
			t = list[i].to;
			ff = Find(f);
			ft = Find(t);
			if(ff != ft) {
				parent[ft] = parent[ff];
				answer += list[i].weight;
			}
		}
		System.out.println(answer);
	}
	private static int Find(int x) {
		if(parent[x]==x)
			return x;
		return parent[x] = Find(parent[x]);
	}
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}
}
