long sum_opt(long *val, long i, long j, long n){
    long up, down, left, right, sum;
    long op = i * n + j;
    up = val[op - n];
    down = val[op + n];
    left = val[op - 1];
    right = val[op + 1];
    sum = up + down + left + right;
    return sum;
}