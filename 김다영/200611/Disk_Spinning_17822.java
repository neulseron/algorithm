package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Disk_Spinning_17822 {
	static Integer[][] arr;
	static int[][] rotation;
	static ArrayList<Nodes> remove_arr = new ArrayList<Nodes>();
	static int[] dx = {1, 0, -1, 0}; // 상우하좌
	static int[] dy = {0, 1, 0, -1};
	static int N, M, T, cnt, sum;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new Integer[N][M];
		rotation = new int[T][3];
		int i, j, answer = 0;
		int x, d, k;
		for(i = 0; i < N; i++)
		{
			str = br.readLine();
			st = new StringTokenizer(str);
			for(j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		for(i = 0; i < T; i++)
		{
			str = br.readLine();
			st = new StringTokenizer(str);
			x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			if(k > M / 2)
			{
				k = M - k;
				if(d == 0)
					d = 1;
				else
					d = 0;
			}
			Rotation(x, d, k); // 회전
			Remove_check(); // 숫자 지우기 리스트
			if(remove_arr.size() == 0)
				Change(cnt, sum); // 평균과 비교
			else
			{
				for(j = 0; j < remove_arr.size(); j++)
					arr[remove_arr.get(j).x][remove_arr.get(j).y] = 0;
			}
		}
		for(i = 0; i < N; i++)
			for(j = 0; j < M; j++)
				if(arr[i][j] != 0)
					answer += arr[i][j];
		System.out.println(answer);
	}
	
	private static void Rotation(int x, int d, int k)
	{
		Integer[] tmp;
		int j;
		for(int c = x - 1; c < N; c++)
		{
			if((c + 1) % x == 0)
			{
				tmp = Arrays.copyOf(arr[c], M);
				if(d == 0) // 시계
				{
					for(j = 0; j < M; j++)
						arr[c][(j + k) % M] = tmp[j];
				}
				else // 반시계
				{
					for(j = 0; j < M; j++)
						arr[c][j] = tmp[(j + k) % M];
				}
			}
		}
	}
	
	private static void Remove_check()
	{
		remove_arr.clear();
		cnt = 0;
		sum = 0;
		boolean visited[][] = new boolean[N][M]; // remove_arr에 이미 저장되어있는지 체크
		int i, j, s;
		int next_x, next_y, compare_num;
		boolean check;
		for(s = 0; s < N; s++)
		{
			for(i = 0; i < M; i++)
			{
				check = false;
				compare_num = arr[s][i];
				if(compare_num == 0)
					continue;
				cnt += 1;
				sum += compare_num;
				for(j = 0; j < 4; j++)
				{
					next_x = s + dx[j];
					next_y = i + dy[j];
					if(i == 0 && j == 3)
						next_y = M - 1;
					if(i == M - 1 && j == 1)
						next_y = 0;
					if(0 <= next_x && next_x < N && 0 <= next_y && next_y < M && arr[next_x][next_y] != 0)
					{
						if(compare_num == arr[next_x][next_y])
						{
							check = true;
							if(!visited[next_x][next_y])
							{
								remove_arr.add(new Nodes(next_x, next_y));
								visited[next_x][next_y] = true;
							}
						}
					}
				}
				if(check == true)
				{
					if(!visited[s][i])
					{
						remove_arr.add(new Nodes(s, i));
						visited[s][i] = true;
					}
				}
			}
		}
	}
	
	private static void Change(int cnt, int sum)
	{
		float avg = (float)sum / cnt;
		for(int j = 0; j < N; j++)
			for(int i = 0; i < M; i++)
			{
				if(arr[j][i] != 0)
				{
					if(arr[j][i] > avg)
						arr[j][i] -= 1;
					else if(arr[j][i] < avg)
						arr[j][i] += 1;
				}
			}
	}
}
class Nodes {
	int x, y;
	public Nodes(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}