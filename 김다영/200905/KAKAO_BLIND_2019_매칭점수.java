package programming.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// 패턴 매칭으로 풀기도 하던데 어려워서 문자열 처리 사용...
// 55%...개행 구분이 문제였음 (질문검색)
// 85%...split대신 index이동으로 변경
// 95점... 9번 아무리 고쳐도 틀린다...
// HTML의 기준에 맞지 않는 (즉 url을 알 수 없어 처리 불가능한 페이지도) 있을 수 있다. (9번 오류시)
// meta property org:url ~~~ 이 형식을 다 지킨 url만 진짜 url...
public class KAKAO_BLIND_2019_매칭점수 {
	static String[] url;
	static ArrayList<String>[] externalLink;
	public static void main(String[] args) {
		String word = "blind";
		String[] pages= {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
		System.out.println(solution(word, pages));
		word = "Muzi";
		pages = new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
		System.out.println(solution(word, pages));
	}
	public static int solution(String word, String[] pages) {
        int answer = 0;
        String p;
        int pSize = pages.length;
        url = new String[pSize]; // 각각의 url
        externalLink = new ArrayList[pSize]; // 외부링크 정보
        double[][] score = new double[pSize][5]; // 기본점수, 외부 링크 수, 링크 점수, 매칭 점수, index
        word = word.toLowerCase();
        for(int i = 0; i < pSize; i++) {
        	p = pages[i].toLowerCase();
        	score[i][0] = basicScore(word, p); // 기본점수 계산
        	externalLink[i] = new ArrayList<>();
        	externalLink(p,i); // url & 외부 링크 저장
        	score[i][1] = externalLink[i].size(); // 외부 링크 수 계산
        }
        for(int i = 0; i < pSize; i++) {
        	for(int j = 0; j < pSize; j++) {
        		if(i == j) continue;
        		for(String s : externalLink[j]) { // 링크 점수 계산
        			if(s.equals(url[i])) score[i][2] += (score[j][0]/score[j][1]);
        		}
        	}
        	score[i][3] = score[i][0] + score[i][2]; // 매칭 점수
        	score[i][4] = i;
        }
        // 매칭 점수 내림차순 & 같으면 index 오름차순
        Arrays.sort(score, new Comparator<double[]>(){
			@Override
			public int compare(double[] o1, double[] o2) {
				if(Double.compare(o2[3], o1[3])==0) {
					return Double.compare(o1[4], o2[4]);
				}
				return Double.compare(o2[3], o1[3]);
			}
        });
        answer = (int)score[0][4];
        return answer;
    }
	
	// 외부 링크 점수 계산
	private static void externalLink(String page, int idx) {
		int meta, href, start, end=0;
		// url 찾기
		meta = page.indexOf("<meta property=\"og:url\" content=");
		start = page.indexOf("https://", meta);
		if(start != -1) {
			end = page.indexOf("/>", start);
			url[idx] = page.substring(start, end-1);
		}
		
		// 외부 링크 찾기
		href = page.indexOf("<a href");
		while(href >= 0) {
			start = page.indexOf("https://", href);
			if(start != -1) {
				end = page.indexOf(">", start);
				externalLink[idx].add(page.substring(start, end-1));
			}else break;
			href = page.indexOf("<a href", end);
		}
	}
	// 기본 점수 계산
	private static int basicScore(String word, String page) {
		int cnt = 0, start = 0;
		char ch1, ch2;
		start = page.indexOf(word);
		while(start >= 0) {
			ch1 = page.charAt(start + word.length());
			if(!('a' <= ch1 && ch1 <= 'z')) {
				if(start == 0) {
					cnt++;
				}else {
					ch2 = page.charAt(start-1);
					if(!('a' <= ch2 && ch2 <= 'z')) 
						cnt++;
				}
			}
			start = page.indexOf(word, start+1);
		}
		return cnt;
	}
}