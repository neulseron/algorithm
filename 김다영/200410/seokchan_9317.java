import java.io.FileInputStream;
import java.util.Scanner;

public class seokchan_9317 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_9317.txt"));
		
		Scanner scan = new Scanner(System.in);
		int TC = scan.nextInt(); // �׽�Ʈ���̽�
		int N = 0;
		int cnt = 0;
		String str_1;
		String str_2;
		for(int i = 1; i <= TC; i++)
		{
			N = scan.nextInt(); // ���ڿ� ����
			str_1 = scan.next(); // ���� ���ڿ�
			str_2 = scan.next(); // �޾ƾ� ���ڿ�
			cnt = 0;
			for(int j = 0;j < N;j++)
			{
				if(str_1.charAt(j)==str_2.charAt(j))
					cnt++;
			}
			System.out.println("#" + i + " " + cnt);
		}
	}

}
