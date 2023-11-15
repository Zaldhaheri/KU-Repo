int scale(int x, int y, int z) {
    int result;
    result = y * 8;
    result += x;
    result += 4;
    return result;
}