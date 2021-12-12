vector<int> gradingStudents(vector<int> grades) {
    vector<int> answer (grades.size());
    for (int i = 0; i < grades.size(); i++) {
        if (grades[i] % 5 > 2 && grades[i] >= 38) {
            answer[i] = grades[i] - (grades[i] % 5) + 5;
        } else {
            answer[i] = grades[i];
        }
    }
    return answer;
}
