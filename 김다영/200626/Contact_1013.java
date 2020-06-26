package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact_1013 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Pattern pattern = Pattern.compile("(100+1+|01)+");
		Matcher match;
		for(int tc = 0 ; tc < T; tc++)
		{
			match = pattern.matcher(br.readLine());
			if(match.matches())
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}