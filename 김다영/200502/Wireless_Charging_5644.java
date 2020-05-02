import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Wireless_Charging_5644 {
	static int[][] AP_info;
	static int[] User_A;
	static int[] User_B;
	static int M, A; // 시간, AP 수
	static int answer;
	static int[] A_xy = {1, 1};
	static int[] B_xy = {10, 10};
	static int[] dx = {0, 0, 1, 0, -1};
	static int[] dy = {0, -1, 0, 1, 0};

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_5644.txt"));
		Scanner scan = new Scanner(System.in);
		int TC = scan.nextInt();
		int j, k;
		for(int i = 1; i <= TC; i++)
		{
			answer = 0;
			A_xy[0] = 1;
			A_xy[1] = 1;
			B_xy[0] = 10;
			B_xy[1] = 10;
			
			M = scan.nextInt();
			A = scan.nextInt();
			User_A = new int[M];
			for(j = 0; j < M; j++)
				User_A[j] = scan.nextInt();
			User_B = new int[M];
			for(j = 0; j < M; j++)
				User_B[j] = scan.nextInt();
			AP_info = new int[A][4]; // x, y, C, P
			for(j = 0; j < A; j++)
			{
				for(k = 0; k < 4; k++)
					AP_info[j][k] = scan.nextInt();
			}
			Cal_BC();
			for(j = 0; j < M; j++)
			{
				Move(User_A[j], User_B[j]);
				Cal_BC();
			}
			System.out.println("#" + i + " " + answer);
		}
	}
	
	public static void Cal_BC()
	{
		int dist_A;
		int dist_B;
		ArrayList<Integer> tmp1;
		ArrayList<Integer> tmp2;
		ArrayList<ArrayList<Integer>> A_P_arr = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> B_P_arr = new ArrayList<ArrayList<Integer>>();
		for(int j = 0; j < A; j++)
		{
			tmp1 = new ArrayList<Integer>();
			dist_A = (Math.abs(A_xy[0] - AP_info[j][0]) + Math.abs(A_xy[1] - AP_info[j][1]));
			if(dist_A <= AP_info[j][2])
			{
				tmp1.add(AP_info[j][3]);
				tmp1.add(j);
				A_P_arr.add(tmp1);
			}
			tmp2 = new ArrayList<Integer>();
			dist_B = (Math.abs(B_xy[0] - AP_info[j][0]) + Math.abs(B_xy[1] - AP_info[j][1]));
			if(dist_B <= AP_info[j][2])
			{
				tmp2.add(AP_info[j][3]);
				tmp2.add(j);
				B_P_arr.add(tmp2);
			}
		}
		sort(A_P_arr);
		sort(B_P_arr);
		if(A_P_arr.isEmpty() && B_P_arr.isEmpty()) // A = 0, B = 0
			return;
		else if(A_P_arr.isEmpty()) // A = 0, B > 0
			answer += B_P_arr.get(0).get(0);
		else if(B_P_arr.isEmpty()) // A > 0, B = 0
			answer += A_P_arr.get(0).get(0);
		else if(A_P_arr.get(0).get(0).equals(B_P_arr.get(0).get(0))) // 최댓값이 동일
		{
			if(A_P_arr.get(0).get(1) != B_P_arr.get(0).get(1)) // 다른 AP면
			{
				answer += A_P_arr.get(0).get(0);
				answer += B_P_arr.get(0).get(0);
			}
			else
			{
				if(A_P_arr.size() == 1 && B_P_arr.size() == 1) // A = 1, B = 1
				{
					answer += A_P_arr.get(0).get(0);
				}
				else if(A_P_arr.size() == 1) // A = 1, B > 1
				{
					answer += A_P_arr.get(0).get(0);
					answer += B_P_arr.get(1).get(0);
				}
				else if(B_P_arr.size() == 1) // A > 1, B = 1
				{
					answer += A_P_arr.get(1).get(0);
					answer += B_P_arr.get(0).get(0);
				}
				else // A > 1, B > 1
				{
					answer += A_P_arr.get(0).get(0);
					answer += Math.max(A_P_arr.get(1).get(0), B_P_arr.get(1).get(0));
				}
			}
		}
		else // 최댓값이 다름
		{
			answer += A_P_arr.get(0).get(0);
			answer += B_P_arr.get(0).get(0);
		}
	}
	
	public static void Move(int direction_A, int direction_B)
	{
		A_xy[0] += dx[direction_A];
		A_xy[1] += dy[direction_A];
		B_xy[0] += dx[direction_B];
		B_xy[1] += dy[direction_B];
	}
	
	public static void sort(ArrayList<ArrayList<Integer>> arr)
	{
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		for(int j = 0; j < arr.size(); j++)
			tmp.add(arr.get(j).get(0));
		tmp.sort(null);
		Collections.reverse(tmp);
		for(int j = 0; j < tmp.size(); j++)
			for(int k = 0; k < tmp.size(); k++)
				if(tmp.get(j).equals(arr.get(k).get(0)))
				{
					arr.add(arr.get(k));
					arr.remove(k);
					break;
				}
	}
}