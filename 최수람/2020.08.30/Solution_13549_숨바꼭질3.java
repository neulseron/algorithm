package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
// 다익스트라로 풀기 

public class Solution_13549_숨바꼭질3 {
	static int N,K;
	static int dist[];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		dist=new int [200001];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dfs();
		System.out.println(dist[K]);
	}//end of main
	static int dir[]= {1,-1};
	private static void dfs() {
		Queue<int []> q=new LinkedList<>();
		q.add(new int [] {N,0});
		dist[N]=0;
		while(!q.isEmpty()) {
			int cur[]=q.poll();
			int n=cur[0];
			int t=cur[1];
			if(t>dist[n]) {
				continue;
			}
			if(n==K) {
				return ;
			}
			for(int d=0;d<2;d++) {
				int nnum=n+dir[d];
				if(nnum<0||nnum>200000) continue;
				if(dist[n]+1<dist[nnum]) {
					dist[nnum]=dist[n]+1;
					q.add(new int [] {nnum,dist[nnum]});
				}
			}
			int nnum=n*2;
			if(nnum>=0&&nnum<=200000) {
				if(dist[n]<dist[nnum]) {
					dist[nnum]=dist[n];
					q.add(new int [] {nnum,dist[nnum]});
				}
			}
		}
	}
}//end of class 
