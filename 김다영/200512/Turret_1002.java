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
			if(max - min < d && d < max + min) // �� ������ ����
				answer = 2;
			else if(max + min == d) // ����
				answer = 1;
			else if(max - min == d)
			{
				if(d != 0) // ����
					answer = 1;
				else // ������ ��ħ
					answer = -1;
			}
			else if(max - min > d) // ū ���� ���� ���� ����
				answer = 0;
			else if(max + min < d) // �� ���� �ָ� ������ ������ ����
				answer = 0;
			System.out.println(answer);
		}
	}
}