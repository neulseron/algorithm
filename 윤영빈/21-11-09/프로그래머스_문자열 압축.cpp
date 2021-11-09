#include <iostream>
#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(string s) {
    int answer = 0;
    int maxCut = s.length() / 2 + 2;
    
    priority_queue<int, vector<int>, greater<int>> minLength;
    
    for (int cut = 1; cut <= maxCut; cut++) {
        int chkIndex = 0;
        int len = s.length();
        int shrinkLength = 0;
        int sameCnt = 0;
        
        ///**/cout << "\n** cut : " << cut << "\n";
        
        while (chkIndex + cut < s.length()) {
            ///**/cout << "[chkIndex] " << chkIndex <<"\n";
            
            string str = "";
            for (int i = 0 + chkIndex; i < cut + chkIndex; i++) {
                str += s[i];
            }
            chkIndex += cut;
            ///**/cout << "loop word : " << str << "\n";

            bool isDiff = false;
            string compStr = "";
            
            sameCnt = 0;
            shrinkLength = 0;

            for (int i = chkIndex; i < s.length(); i += cut) {
                compStr = "";
                for (int j = 0; j < cut; j++) {
                    if (s[i + j] != str[j]) {
                        isDiff = true;
                        break;
                    }
                    compStr += s[i + j];
                }
                if (isDiff)     break;
                sameCnt++;
                ///**/cout << "\tcomp word : " << compStr << ", cnt : " << sameCnt <<"\n";

                shrinkLength = cut * sameCnt;
                ///**/cout << "\t\tshrink Length : " << shrinkLength <<"\n";
            }   
            
            chkIndex += shrinkLength;
            
            if (shrinkLength > 1) {
                int same = shrinkLength / cut;
                /**/if (same == 9) same++;
                
                int tmp = 0;
                while (same > 0) {
                    same /= 10;
                    tmp++;
                }
                
                ///**/cout << "\t=> pre Len : " << len << ", shrinkLength : " << shrinkLength << ", Len : " << len << ", sameCnt : " << shrinkLength / cut;
                
                len = len - shrinkLength + tmp;
                
                cout << ", post Len : " << len << "\n";
            }
        }
        
        minLength.push(len);
        ///**/cout << "## Original : " << s.length() << ", Length : " << len << "\n";
    }
    
    return minLength.top();
}
