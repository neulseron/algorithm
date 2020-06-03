package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Teaching_1062 {
	static ArrayList<Character> arr;
	static String[] str_arr;
	static char[] char_arr;
	static int N, K, answer, charLength;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = 0;
		int zero = 0;
		if(K < 5)
		{
			System.out.println(answer);
			return;
		}
		K -= 5;
		str_arr = new String[N];
		arr = new ArrayList<Character>();
		int i, j;
		char tmp;
		for(i = 0 ; i < N; i++)
		{
			str = br.readLine();
			str = str.replaceAll("a", "");
			str = str.replaceAll("n", "");
			str = str.replaceAll("t", "");
			str = str.replaceAll("i", "");
			str = str.replaceAll("c", "");
			str_arr[i] = str;
			if(str.length()==0)
			{
				zero++;
				continue;
			}
			for(j = 0; j < str.length(); j++)
			{
				tmp = str.charAt(j);
				if(!arr.contains(tmp))
					arr.add(tmp);
			}	
		}
		if(K > 0)
		{
			charLength = arr.size();
			char_arr = new char[charLength];
			if(K > charLength)
				K = charLength;
			for(i = 0; i < charLength; i++)
				char_arr[i] = arr.get(i);
			Solve(new ArrayList<Character>(), 0, 0);
		}
		System.out.println(answer + zero);
	}
	
	public static void Solve(ArrayList<Character> select_arr, int idx, int cnt)
	{
		int i, j, k;
		char tmp;
		if(cnt == K)
		{
			int count = 0;
			for(j = 0; j < str_arr.length; j++)
			{
				String stmp = str_arr[j];
				if(stmp.length() == 0)
					continue;
				for(k = 0; k < stmp.length(); k++)
				{
					tmp = stmp.charAt(k);
					if(!select_arr.contains(tmp))
						break;
				}
				if(k == stmp.length())
					count++;
			}
			answer = Math.max(answer, count);
			return;
		}
		for(i = idx; i < charLength; i++)
		{
			select_arr.add(char_arr[i]);
			Solve(select_arr, i + 1, cnt + 1);
			select_arr.remove(select_arr.indexOf(char_arr[i]));
		}
	}
}