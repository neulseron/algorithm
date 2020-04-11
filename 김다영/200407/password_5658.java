import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class password_5658 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_5658.txt"));
		
		Scanner scan = new Scanner(System.in);
		int test_case = 0;
		test_case = scan.nextInt();
		for(int i = 1; i <= test_case; i++)
		{
			int N = scan.nextInt();
			int K = scan.nextInt();
			String str = scan.next();
			List<String> str_list = new ArrayList<String>();
			int j = 0;
			int r = 1;
			int val1 = N;
			int val2 = (N / 4) + 1;
			while(r>0)
			{
				r = val1 % val2;
				val1 = val2;
				val2 = r;
			}
			int LCM = N * ((N / 4) + 1) / val1;
			int side_len = (N / 4); // 변의 길이
			int rotation_cnt = LCM / (side_len + 1); // 회전 수
			for(j = 0; j < rotation_cnt; j++)
			{
				str_list.add(str.substring(0, side_len));
				str_list.add(str.substring(side_len, side_len * 2));
				str_list.add(str.substring(side_len * 2, side_len * 3));
				str_list.add(str.substring(side_len * 3, side_len * 4));
				String tmp = str.substring(side_len + 1);
				tmp += str.substring(0, side_len + 1);
				str = tmp;
			}
			List<String> str_array = new ArrayList<String>(new LinkedHashSet<String>(str_list));
			str_array.sort(Comparator.reverseOrder());
			int answer = 0;
			for(j = 0;j < side_len; j++)
			{
				if('0' <= str_array.get(K - 1).charAt(j) && str_array.get(K - 1).charAt(j) <= '9')
					answer += (int)((str_array.get(K - 1).charAt(j) - 48) * Math.pow(16, side_len - 1 - j)) ;
				else
					answer += (int)((str_array.get(K - 1).charAt(j) - 55) * Math.pow(16, side_len - 1 - j)) ;
			}
			System.out.println("#" + i + " " + answer);
		}
	}
}
