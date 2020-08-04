package programming.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1238_Contact {

	static boolean[][] person;
	static boolean[] visited;
	static int max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		String str ="";
//		while((str = br.readLine()) != null) {
		while(!(str = br.readLine()).equals("")) {
			sb.append("#" + tc++ + " ");
			person = new boolean[101][101];
			visited = new boolean[101];
			st = new StringTokenizer(str);
			int N = Integer.parseInt(st.nextToken().trim());
			int v = Integer.parseInt(st.nextToken().trim()); // 시작 정점
			st = new StringTokenizer(br.readLine());
			int from, to, v_cnt = 0;
			max = 0;
			for(int i = 0; i < N/2; i++) {
				from = Integer.parseInt(st.nextToken().trim());
				to = Integer.parseInt(st.nextToken().trim());
				max = Math.max(Math.max(from, to), max);
				person[from][to] = true;
				if(v == from)
					v_cnt++;
			}
			if(v_cnt == 0) {
				sb.append(v + "\n");
				continue;
			}
			sb.append(bfs(v) + "\n");
		}
		System.out.println(sb);
	}
	private static int bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		visited[v] = true;
		int size, tmp, large = 0;
		while(!queue.isEmpty()) {
			large = 0;
			size = queue.size();
			for(int j = 0; j < size; j++) {
				tmp = queue.poll();
				large = (large < tmp) ? tmp : large;
				for(int i = 1; i <= max; i++) {
					if(person[tmp][i] && !visited[i]) {
						queue.offer(i);
						visited[i] = true;
					}
				}
			}
		}
		return large;
	}
}