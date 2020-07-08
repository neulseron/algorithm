import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Initial_Word_8741 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int i;
		String answer;
		String[] str_arr;
		for(int tc = 1; tc <= T; tc++)
		{
			answer = "";
			str_arr = br.readLine().split(" ");
			for(i = 0; i < str_arr.length; i++)
				answer += str_arr[i].charAt(0);
			System.out.println("#" + tc + " " + answer.toUpperCase());
		}
	}
}