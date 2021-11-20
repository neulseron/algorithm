#include <iostream>
#include <vector>

using namespace std;

int N;
//vector<vector<int>> ability;
int ability [20][20] = { };
//vector<bool> team;
bool team [20] = { };
int answer = 9999999;

void makeTeam(int idx, int nop)
{
    if (nop == N/2) {
        vector<int> teamLink, teamStart;
        for (int i = 0; i < N; i++) {
            if (team[i]) teamStart.push_back(i);
            else teamLink.push_back(i);
        }

        int abilityStart = 0, abilityLink = 0;
        for (int i = 0; i < (N >> 1); i++) {
            for (int j = 0; j < (N >> 1); j++) {
                abilityLink += ability[teamLink[i]][teamLink[j]];
                abilityStart += ability[teamStart[i]][teamStart[j]];
            }
        }

        answer = min(answer, abs(abilityStart - abilityLink));

        return;
    }

    for (int i = idx; i < N; i++) {
        if (team[i])   continue;

        team[i] = true;
        makeTeam(i, nop + 1);
        team[i] = false;
    }
}

int main()
{
    /*
    ios::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);
    */

    //cin >> N;
    scanf("%d", &N);
    //team.assign(N/2, false);
    //ability.assign(N, vector<int> (N, 0));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            //cin >> ability[i][j];
            scanf("%d", &ability[i][j]);
        }
    }

    makeTeam(0, 0);

    cout << answer;
}
