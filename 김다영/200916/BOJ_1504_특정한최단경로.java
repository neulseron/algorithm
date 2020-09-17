package baekjoon.no_1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504_특정한최단경로 {
	static int N;
	static ArrayList<Vertex>[] vertex;
	static final int INF = 100000000;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int f,t,w, rq1, rq2;
		vertex = new ArrayList[N+1];
		for(int i = 0; i <= N; i++)
			vertex[i] = new ArrayList<>();
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			f = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			vertex[f].add(new Vertex(t, w));
			vertex[t].add(new Vertex(f, w));
		}
		st = new StringTokenizer(br.readLine());
		rq1 = Integer.parseInt(st.nextToken());
		rq2 = Integer.parseInt(st.nextToken());
		
		// 경로 1
		int result1 = makeMST(1, rq1);
		result1 += makeMST(rq1, rq2);
		result1 += makeMST(rq2, N);
		
		// 경로 2
		int result2 = makeMST(1, rq2);
		result2 += makeMST(rq2, rq1);
		result2 += makeMST(rq1, N);
		
		int answer;
		if(result1 >= INF && result2 >= INF) answer = -1;
		else answer = result1 < result2 ? result1 : result2;
		
		System.out.println(answer);
	}
	private static int makeMST(int from, int to) {
		int result = 0, cnt = 0, result2 = 0, no1, no2;
		boolean[] visited = new boolean[N+1];
		int[] minEdge = new int[N+1];
		Arrays.fill(minEdge, INF);
		minEdge[from] = 0;
		PriorityQueue<Vertex> pq = new PriorityQueue<>((o1,o2)->{return o1.cost-o2.cost;});
		pq.offer(new Vertex(from, minEdge[from]));
		
		while(!pq.isEmpty()) {
			Vertex v = pq.poll();
			no1 = v.no;
			result = v.cost;
			if(visited[no1]) continue;
			visited[no1] = true;
			if(++cnt == N+1) break;
			
			for(int i = 0; i < vertex[no1].size(); i++) {
				result2 = vertex[no1].get(i).cost;
				no2 = vertex[no1].get(i).no;
				if(!visited[no2] && minEdge[no2] > result + result2) {
					minEdge[no2] = result + result2;
					pq.offer(new Vertex(no2, minEdge[no2]));
				}
			}
		}
		return minEdge[to];
	}
	
	static class Vertex{
		int no, cost;
		public Vertex(int no, int cost) {
			this.no = no;
			this.cost = cost;
		}
	}
}