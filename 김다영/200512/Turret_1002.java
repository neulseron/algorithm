package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Turret_1002 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int T = Integer.parseInt(st.nextToken());
		int x1, y1, r1, x2, y2, r2, max, min;
		double d;
		int answer = 0;
		for(int i = 0; i < T; i++)
		{
			str = br.readLine();
			st = new StringTokenizer(str);
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			max = Math.max(r1, r2);
			min = Math.min(r1, r2);
			d = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
			if(max - min < d && d < max + min) // 두 점으로 만남
				answer = 2;
			else if(max + min == d) // 외접
				answer = 1;
			else if(max - min == d)
			{
				if(d != 0) // 내접
					answer = 1;
				else // 완전히 겹침
					answer = -1;
			}
			else if(max - min > d) // 큰 원이 작은 원을 포함
				answer = 0;
			else if(max + min < d) // 두 원이 멀리 떨어져 만나지 않음
				answer = 0;
			System.out.println(answer);
		}
	}
}