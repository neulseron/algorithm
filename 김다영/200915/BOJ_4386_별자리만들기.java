package baekjoon.no_4000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4386_별자리만들기 {
	static int[] number;
	static int N;
	static Point[] node;
	static double[][] vertex;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		node = new Point[N];
		vertex = new double[N][N];
		number = new int[2];
		// 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			node[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		}
		// 간선 가중치 계산
		comb(0,0);
		// Prim
		System.out.println(makeMST());
		
	}
	private static double makeMST() {
		double result = 0, cnt = 0;
		double[] minEdge = new double[N];
		boolean[] visited = new boolean[N];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		// 시작정점 : 0
		minEdge[0] = 0;
		PriorityQueue<Vertex> pq = new PriorityQueue<>((p1,p2)->{return Double.compare(p1.cost, p2.cost);});
		pq.offer(new Vertex(0, minEdge[0]));
		
		while(true) {
			Vertex tmp = pq.poll();
			if(visited[tmp.no]) continue;
			// 방문 처리. 비용 합산. 모든 정점 방문 시 break;
			visited[tmp.no] = true;
			result += tmp.cost;
			if(++cnt == N) break;
			// 현재 연결되지 않은 정점으로의 최소 간선 비용 갱신
			for(int i = 0; i < N; i++) {
				if(!visited[i] && vertex[tmp.no][i] > 0 && minEdge[i] > vertex[tmp.no][i]) {
					minEdge[i] = vertex[tmp.no][i];
					pq.offer(new Vertex(i, minEdge[i]));
				}
			}
		}
		
		return result;
	}
	private static void comb(int cnt, int start) {
		if(cnt == 2) {
			Point p1 = node[number[0]];
			Point p2 = node[number[1]];
			double distance = Math.sqrt(Math.pow(p1.x-p2.x, 2) + Math.pow(p1.y-p2.y, 2));
			vertex[number[0]][number[1]] = Math.round(distance*100)/100.0;
			vertex[number[1]][number[0]] = Math.round(distance*100)/100.0;
			return;
		}
		for(int i = start; i < N; i++) {
			number[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	static class Point{
		double x,y;
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Vertex{
		int no;
		double cost;
		public Vertex(int no, double cost) {
			this.no = no;
			this.cost = cost;
		}
	}
}