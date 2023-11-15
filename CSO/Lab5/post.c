int logical(int x, int y) {
    int result = x;
    result = result ^ y;
    result = result >> 17;
    result = result & 8185;
    return result;
}