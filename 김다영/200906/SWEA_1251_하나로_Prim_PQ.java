package programming.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1251_하나로_Prim_PQ {

	private static int N;
	private static long[][] adjMatrix;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			
			int[] x = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				x[i] = Integer.parseInt(st.nextToken().trim());
			
			int[] y = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				y[i] = Integer.parseInt(st.nextToken().trim());
			
			adjMatrix = new long[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					adjMatrix[i][j] = adjMatrix[j][i] = getDistance(x[i],x[j],y[i],y[j]);
				}
			}
			double E = Double.parseDouble(br.readLine().trim());
			System.out.println("#" + tc + " " + Math.round(E*makeMST()));
		}

	}
	
	private static long makeMST() {
		long[] minEdge = new long[N];
		boolean[] visited = new boolean[N];
		
		long result = 0; // 최소신장트리 비용
		int cnt = 0; // 처리한 정점 수
		
		Arrays.fill(minEdge, Long.MAX_VALUE);
		minEdge[0] = 0; // 0을 시작점으로
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>();
		pQueue.offer(new Vertex(0,minEdge[0]));
		
		while(true) {
			// 1단계 : 신장트리에 포함되지 않은 정점 중에 최소 간선 비용의 정점 선택
			Vertex minVertex = pQueue.poll();
			if(visited[minVertex.no]) continue;
			
			visited[minVertex.no] = true; // 신장트리에 포함
			result += minVertex.cost; // 간선비용 누적
			if(++cnt == N) break;
			
			// 2단계 : 선택된 정점에서 신장트리에 포함되지 않은 다른 정점들로의 간선의 비용을 고려하여 minEdge 업데이트
			for(int i = 0; i < N; i++) {
				if(!visited[i] && adjMatrix[minVertex.no][i] > 0 && minEdge[i] > adjMatrix[minVertex.no][i]) {
					minEdge[i] = adjMatrix[minVertex.no][i];
					pQueue.offer(new Vertex(i, minEdge[i]));
				}
			}
		}
		return result;
	}
	
	private static long getDistance(int x1, int x2, int y1, int y2) {
		return (long)(Math.pow((x1-x2), 2) + Math.pow((y1-y2),2));
	}
	static class Vertex implements Comparable<Vertex>{
		int no;
		long cost;
		public Vertex(int no, long cost) {
			this.no = no;
			this.cost = cost;
		}
		@Override
		public int compareTo(Vertex o) {
			return Long.compare(this.cost, o.cost);
		}
	}
}
