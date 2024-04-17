vector<pair<int, int>> dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

vector<int> solution(vector<string> maps)
{
    vector<int> answer;

    vector<vector<bool>> visit(maps.size(), vector<bool>(maps[0].size(), false));
    
    for (int i = 0; i < maps.size(); ++i)
    {
        for (int j = 0; j < maps[0].size(); ++j)
        {
            if (maps[i][j] != 'X' && visit[i][j] == false)
            {
                visit[i][j] = true;
                int food = maps[i][j] - '0';

                queue<pair<int, int>> waiting;
                waiting.push({i, j});

                while (waiting.empty() == false)
                {
                    pair<int, int> curr = waiting.front();
                    waiting.pop();

                    for (int d = 0; d < dir.size(); ++d)
                    {
                        pair<int, int> next = {curr.first + dir[d].first, curr.second + dir[d].second};

                        if (next.first < 0 || next.first >= maps.size() || next.second < 0 || next.second >= maps[0].size())
                            continue;

                        if (maps[next.first][next.second] == 'X' || visit[next.first][next.second] == true)
                            continue;

                        waiting.push({next.first, next.second});
                        visit[next.first][next.second] = true;
                        food += (maps[next.first][next.second] - '0');
                    }
                }

                answer.push_back(food);
            }
        }
    }

    if (answer.size() == 0)
        return {-1};
    
    sort(answer.begin(), answer.end());

    return answer;
}
