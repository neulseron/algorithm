package programming.baekjoon.no_15000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15961_회전초밥 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken().trim());
		int d = Integer.parseInt(st.nextToken().trim());
		int k = Integer.parseInt(st.nextToken().trim());
		int c = Integer.parseInt(st.nextToken().trim());
		int cnt = 0, tmp, max = 0;
		Queue<Integer> qI = new LinkedList<>();
		int[] visited = new int[d+1];
		int[] front = new int[k-1];

		for(int i = 0; i < k-1; i++) {
			tmp = Integer.parseInt(br.readLine().trim());
			front[i] = tmp;
			qI.offer(tmp);
			if(visited[tmp]++ == 0)
				cnt++;
		}
		for(int i = k-1; i < N+k-1; i++) {
			if(i < N)
				tmp = Integer.parseInt(br.readLine().trim());
			else
				tmp = front[i-N];
			qI.offer(tmp);
			if(visited[tmp]++ == 0)
				cnt++;
			
			if(visited[c] == 0)	
				max = max < cnt+1 ? cnt+1 : max;
			else 
				max = max < cnt ? cnt : max;
			
			if(--visited[qI.poll()] == 0)
				cnt--;
		}
		System.out.println(max);
	}
}