import java.io.FileInputStream;
import java.util.Scanner;
public class Palindrome2_1216 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_1216.txt"));
		Scanner scan = new Scanner(System.in);
		int TC, check, answer;
		int i, j, k, s, p;
		String str;
		for(i = 1; i <= 10; i++)
		{
			TC = scan.nextInt();
			char[][] arr = new char[100][100];
			answer = 0;
			for(j = 0; j < 100; j++)
			{
				str = scan.next();
				for(k = 0; k < 100; k++)
				{
					arr[j][k] = str.charAt(k);
				}
				// 가로 확인
				for(k = 0; k < 100; k++)
				{
					for(s = 0; s < 100; s++)
					{
						if((100-k-s) <= answer)
							break;
						check = 0;
						for(p = 0; p < (100-k -s)/2; p++)
						{
							if(arr[j][p + s] != arr[j][99 - k - p])
							{
								check = 1;
								break;
							}
						}
						if(check == 0)
							answer = (100-k-s);
					}
				}
			}
			for(j = 0; j < 100; j++)
			{
				// 세로 확인
				for(k = 0; k < 100; k++)
				{
					for(s = 0; s < 100; s++)
					{
						if((100-k-s) <= answer)
							break;
						check = 0;
						for(p = 0; p < (100-k -s)/2; p++)
						{
							if(arr[p + s][j] != arr[99 - k - p][j])
							{
								check = 1;
								break;
							}
						}
						if(check == 0)
							answer = (100-k-s);
					}
				}
			}
			System.out.println("#" + TC + " " + answer);
		}
	}
}