package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SangGeun_Nald_5543 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int min = Integer.MAX_VALUE;
		int tmp, i;
		for(i = 0; i < 3; i++)
		{
			tmp = Integer.parseInt(br.readLine());
			if(min > tmp)
				min = tmp;
		}
		answer += min;
		min = Integer.MAX_VALUE;
		for(i = 0; i < 2; i++)
		{
			tmp = Integer.parseInt(br.readLine());
			if(min > tmp)
				min = tmp;
		}
		answer += min;
		answer -= 50;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(Integer.toString(answer));
		br.close();
		bw.close();
	}
}