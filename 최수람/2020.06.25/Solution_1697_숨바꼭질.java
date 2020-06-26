

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1697_숨바꼭질 {
	static int N,K;
	static int answer;
	static boolean visit[];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine().trim()," ");
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		answer=0;
		visit=new boolean[100002];
		bfs();
		System.out.println(answer);
	}//end of main
	private static void bfs() {
		Queue<int[]> queue=new LinkedList<>();
		queue.add(new int []{N,0});
		visit[N]=true;
		while(!queue.isEmpty()){
			int [] cur=queue.poll();
			int location=cur[0];
			int cnt=cur[1];
			if(location==K){
				answer=cnt;
				return;
			}
			if(location-1>=0 && !visit[location-1]){
					visit[location-1]=true;
					queue.add(new int []{location-1,cnt+1});
			}
			if(location+1<=100000 && !visit[location+1]){
					visit[location+1]=true;
					queue.add(new int []{location+1,cnt+1});
			}
			if(2*location<=100000 && !visit[2*location]){
					visit[2*location]=true;
					queue.add(new int []{2*location,cnt+1});
			}
		}
	}
}//end of class 
