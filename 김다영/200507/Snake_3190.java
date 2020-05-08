package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Snake_3190 {
	static int time;
	static int x;
	static int y;
	static int N;
	static int[][] visited;
	static ArrayList<Integer> change_arr;
	static ArrayList<Character> change_direction;
	static ArrayList<ArrayList<Integer>> path;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {-1, 0, 1, 0};
	static int direction;
	static int change_time;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		x = 0;
		y = 0;
		time = 0;
		direction = 1; // ¿À¸¥ÂÊ
		path = new ArrayList<ArrayList<Integer>>();
		N = scan.nextInt();
		visited = new int[N][N];
		int K = scan.nextInt();
		int i;
		for(i = 0; i < K; i++)
		{
			visited[scan.nextInt() - 1][scan.nextInt() - 1] = 2;
		}
		int L = scan.nextInt();
		change_arr = new ArrayList<Integer>();
		change_direction = new ArrayList<Character>();
		for(i = 0; i < L; i++)
		{
			change_arr.add(scan.nextInt());
			change_direction.add(scan.next().charAt(0));
		}
		change_time = change_arr.get(0);
		Solve();
		System.out.println(time);
	}
	
	public static void Solve()
	{
		int del_x, del_y;
		ArrayList<Integer> tmp_int = new ArrayList<Integer>();
		tmp_int.add(x);
		tmp_int.add(y);
		path.add(tmp_int);
		visited[x][y] = 1;
		while(true)
		{
			time += 1;
			x += dx[direction];
			y += dy[direction];
			if(x < 0 || y < 0 || x >= N || y >= N)
			{
				break;
			}
			if(visited[x][y] == 1)
				break;
			tmp_int = new ArrayList<Integer>();
			tmp_int.add(x);
			tmp_int.add(y);
			path.add(tmp_int);
			if(visited[x][y] != 2)
			{
				del_x = path.get(0).get(0);
				del_y = path.get(0).get(1);
				visited[del_x][del_y] = 0;
				path.remove(0);
			}
			visited[x][y] = 1;
			if(change_time == time)
			{
				if(change_direction.get(0) == 'D')
					direction += 1;
				else
					direction -= 1;
				if(direction == 4)
					direction = 0;
				if(direction == -1)
					direction = 3;
				change_arr.remove(0);
				change_direction.remove(0);
				if(change_arr.isEmpty() == false)
					change_time = change_arr.get(0);
			}
		}
	}
}