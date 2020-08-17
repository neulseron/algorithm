package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11724_연결요소의개수 {
	static int[] parents;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken().trim());
		int M = Integer.parseInt(st.nextToken().trim());
		int start, end, fs, fe;
		
		parents = new int[N + 1];
		for(int i = 1; i <= N; i++)
			parents[i] = i;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken().trim());
			end = Integer.parseInt(st.nextToken().trim());
			fs = find(start);
			fe = find(end);
			if(fs != fe) {
				parents[fe] = fs;
				N -= 1;
			}
		}
		System.out.println(N);
	}
	private static int find(int a) {
		if(parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
}
