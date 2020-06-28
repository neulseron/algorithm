package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Movie_Director_1436 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int number = 666;
		while(true)
		{
			if(Integer.toString(number).contains("666"))
				cnt++;
			if(cnt == N)
				break;
			number++;
		}
		System.out.println(number);
	}
}