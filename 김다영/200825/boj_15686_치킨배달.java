package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_15686_치킨배달 {
	static House_Chicken[] arr; // 조합
	static int M, answer = Integer.MAX_VALUE;
	static ArrayList<House_Chicken> chicken, house;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken().trim());
		M = Integer.parseInt(st.nextToken().trim());
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		arr = new House_Chicken[M];
		int tmp;
		// 집과 치킨집 나눠서 저장
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				tmp = Integer.parseInt(st.nextToken().trim());
				if(tmp == 1)
					house.add(new House_Chicken(i, j));
				else if(tmp == 2)
					chicken.add(new House_Chicken(i, j));
			}
		}
		comb(0, 0);
		System.out.println(answer);
	}

	private static void comb(int start, int cnt) {
		if(cnt == M) {
			int minD, distance, tmpSum = 0;
			for(House_Chicken h : house) {
				minD = Integer.MAX_VALUE;
				for(House_Chicken c : arr) {
					distance = Math.abs(c.x-h.x) + Math.abs(c.y-h.y);
					minD = minD > distance ? distance : minD;
				}
				tmpSum += minD;
			}
			answer = answer > tmpSum ? tmpSum : answer;
			return;
		}
		for(int i = start; i < chicken.size(); i++) {
			arr[cnt] = chicken.get(i);
			comb(i + 1, cnt + 1);
		}
	}
}

class House_Chicken{
	int x,y;
	public House_Chicken(int x, int y) {
		this.x = x;
		this.y = y;
	}
}