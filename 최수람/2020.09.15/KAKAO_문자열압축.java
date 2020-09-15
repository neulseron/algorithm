package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KAKAO_문자열압축 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		int answer=solution(s);
		System.out.println(answer);
	}//end of main

	private static int solution(String s) {
		int cnt=1;
		int len=s.length();
		int answer=len;
		//시작 점
		while(cnt<=len) {
			int idx=0;
			String standard=s.substring(idx,idx+cnt);
			String tmp="";
			int c=1;
			int written=0;
			idx=idx+cnt;
			while(idx+cnt<=len) {
				if(standard.equals(s.substring(idx,idx+cnt))) {
					c++;
				}else {
					if(c==1) {
						tmp+=standard;
					}else {
						tmp+=c+standard;
					}
					written=idx-1;
					standard=s.substring(idx,idx+cnt);
					c=1;
				}
				idx=idx+cnt;
			}
			if(c==1) {
				tmp+=standard;
			}else {
				tmp+=c+standard;
			}
			written=idx;
			if(written<len) {
				tmp+=s.substring(written,len);
			}
			answer=Math.min(answer, tmp.length());
			cnt++;
		}
		return answer;
	}
}//end of class 
