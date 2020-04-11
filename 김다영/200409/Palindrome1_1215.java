import java.io.FileInputStream;
import java.util.Scanner;

public class Palindrome1_1215 {

	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("res/input_1215.txt"));
		
		Scanner scan = new Scanner(System.in);
		int length = 0;
		int answer = 0;
		int j = 0, k = 0, s = 0, cnt = 0;
		int range = 0;
		String str;
		char[][] arr = new char[8][8];
		for(int i = 1; i <= 10; i++)
		{
			answer = 0;
			length = scan.nextInt(); // 회문's 길이
			for(j = 0; j < 8; j++)
			{
				range = length - 1;
				str = scan.next();
				for(k = 0; k < 8; k++)
				{
					arr[j][k] = str.charAt(k);
				}
				for(s = 0; s <= 8-length; s++)
				{
					cnt = 0;
					for(k = s; k < length/2 + s; k++)
					{
						if(arr[j][k] == arr[j][range-k])
						{
							cnt++;
						}
					}
					if(cnt == length/2)
					{
						answer++;
					}
					range += 2;
				}
			}
			
			for(j = 0; j < 8; j++)
			{
				range = length - 1;
				for(s = 0; s <= 8-length; s++)
				{
					cnt = 0;
					for(k = s; k < length/2 + s; k++)
					{
						if(arr[k][j] == arr[range-k][j])
						{
							cnt++;
						}
					}
					if(cnt == length/2)
					{
						answer++;
					}
					range += 2;
				}
			}
			System.out.println("#" + i + " " + answer);
		}
	}
}
