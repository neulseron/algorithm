package programming.baekjoon.no_1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken().trim());
		int E = Integer.parseInt(st.nextToken().trim());
		int K = Integer.parseInt(br.readLine().trim());
		int s, e, w;
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		ArrayList<Vertex>[] input = new ArrayList[V];
		for(int i = 0; i < V; i++)
			input[i] = new ArrayList<Vertex>();
		final int INF = Integer.MAX_VALUE;
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken().trim());
			e = Integer.parseInt(st.nextToken().trim());
			w = Integer.parseInt(st.nextToken().trim());
			input[s-1].add(new Vertex(e-1,w));
		}
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		Arrays.fill(distance, INF);
		distance[K-1] = 0;
		
		pq.offer(new Vertex(K-1, distance[K-1]));
		
		Vertex current = null;
		Vertex tmp = null;
		
		while(!pq.isEmpty()) {
			current = pq.poll();
			if(visited[current.x]) continue;// PQ에 남아있던 totalDistance의 최소비용보다 더 큰 상태
			
			visited[current.x] = true;
			
			for(int j = 0; j < input[current.x].size(); j++) {
				tmp = input[current.x].get(j);
				if(!visited[tmp.x] && distance[tmp.x] > current.total + tmp.total) {
					distance[tmp.x] = current.total + tmp.total;
					pq.offer(new Vertex(tmp.x,distance[tmp.x]));
				}
			}
		}
		
		for(int i = 0; i < V; i++) {
			if(distance[i] != INF)
				System.out.println(distance[i]);
			else
				System.out.println("INF");
		}
	}
	static class Vertex implements Comparable<Vertex>{
		int x, total;
		public Vertex(int x, int total) {
			this.x = x;
			this.total = total;
		}
		@Override
		public int compareTo(Vertex v) {
			return this.total - v.total;
		}
	}
}
