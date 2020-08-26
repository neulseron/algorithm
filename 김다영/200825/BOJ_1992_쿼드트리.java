package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리 {
	static int[][] arr;
	static int tmpInt;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		StringBuilder sb;
		String str;
		sb = new StringBuilder();
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		if(N == 1) 
			sb.append(arr[0][0]);
		else 
			sb = DC(0, N, 0, N);
		System.out.println(sb);
	}
	
	private static StringBuilder DC(int xStart, int xEnd, int yStart, int yEnd) {
		StringBuilder s = new StringBuilder();
		String[] tmp = new String[4];
		int zero = 0;
		int one = 0;
		int xMiddle = (xStart + xEnd)/2;
		int yMiddle = (yStart + yEnd)/2;
		
		tmpInt = arr[xStart][yStart];
		if(compare(xStart,xMiddle, yStart, yMiddle, tmp, 0)) {
			tmp[0] = Integer.toString(tmpInt);
			if(tmpInt == 0) zero++;
			else if(tmpInt == 1) one++;
		}
		
		tmpInt = arr[xStart][yMiddle];
		if(compare(xStart, xMiddle, yMiddle, yEnd, tmp, 1)) {
			tmp[1] = Integer.toString(tmpInt);
			if(tmpInt == 0) zero++;
			else if(tmpInt == 1) one++;
		}
		
		tmpInt = arr[xMiddle][yStart];
		if(compare(xMiddle, xEnd, yStart, yMiddle, tmp, 2)) {
			tmp[2] = Integer.toString(tmpInt);
			if(tmpInt == 0) zero++;
			else if(tmpInt == 1) one++;
		}
		
		tmpInt = arr[xMiddle][yMiddle];
		if(compare(xMiddle, xEnd, yMiddle, yEnd, tmp, 3)) {
			tmp[3] = Integer.toString(tmpInt);
			if(tmpInt == 0) zero++;
			else if(tmpInt == 1) one++;
		}
		
		if(zero == 4)
			s.append(0);
		else if(one == 4)
			s.append(1);
		else {
			s.append("(");
			for(int i = 0; i < 4; i++)
				s.append(tmp[i]);
			s.append(")");
		}
		return s;
	}
	
	private static boolean compare(int xStart, int xEnd, int yStart, int yEnd, String[] tmp, int idx) {
		for(int i = xStart; i < xEnd; i++) {
			for(int j = yStart; j < yEnd; j++) {
				if(tmpInt != arr[i][j]) {
					tmp[idx] = DC(xStart, xEnd, yStart, yEnd).toString();
					return false;
				}
			}
		}
		return true;
	}
}