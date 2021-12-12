string kangaroo(int x1, int v1, int x2, int v2) {
    if ((x2 - x1) * (v2 - v1) < 0 && (x1 - x2) % (v2 - v1) == 0) return "YES";
    else return "NO";
}
