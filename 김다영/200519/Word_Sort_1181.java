package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Word_Sort_1181 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str);
		int i, j, k, len, tmp;
		String[] arr = new String[N];
		for(i = 0; i < N; i++)
		{
			str = br.readLine();
			arr[i] = str;
		}
		Arrays.sort(arr, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2)
			{
				return Integer.compare(o1.length(), o2.length());
			}
		});
		for(i = 0; i < N; i++)
		{
			len = arr[i].length();
			for(j = i + 1; j < N; j++)
			{
				tmp = arr[j].length();
				if(len != tmp)
					break;
			}
			Arrays.sort(arr, i, j);
			System.out.println(arr[i]);
			for(k = i + 1; k < j; k++)
			{
				if(arr[k].equals(arr[k - 1]))
					continue;
				System.out.println(arr[k]);
			}
			i = j - 1;
		}
	}
}