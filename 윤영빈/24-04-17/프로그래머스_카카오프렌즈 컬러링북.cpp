vector<int> solution(int m, int n, vector<vector<int>> picture)
{
    int number_of_area = 0;
    int max_size_of_one_area = 0;
    int area = 0;

    vector<pair<int, int>> dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    vector<vector<bool>> visit(picture.size(), vector<bool>(picture[0].size(), false));

    for (int i = 0; i < picture.size(); ++i)
    {
        for (int j = 0; j < picture[0].size(); ++j)
        {
            if (picture[i][j] != 0 && visit[i][j] == false)
            {
                visit[i][j] = true;
                area = 1;

                queue<pair<int, int>> waiting;
                waiting.push({i, j});

                while (waiting.empty() == false)
                {
                    pair<int, int> curr = waiting.front();
                    waiting.pop();

                    for (int d = 0; d < dir.size(); ++d)
                    {
                        pair<int, int> next = {curr.first + dir[d].first, curr.second + dir[d].second};

                        if (next.first < 0 || next.first >= picture.size() || next.second < 0 || next.second >= picture[0].size())
                            continue;

                        if (picture[next.first][next.second] == 0 || picture[next.first][next.second] != picture[i][j] || visit[next.first][next.second] == true)
                            continue;

                        waiting.push({next.first, next.second});
                        visit[next.first][next.second] = true;
                        area++;
                    }
                }
            }
            
            if (area > 0) number_of_area++;
            max_size_of_one_area = max(max_size_of_one_area, area);

            area = 0;
        }
    }

    vector<int> answer(2);
    answer[0] = number_of_area;
    answer[1] = max_size_of_one_area;
    return answer;
}
