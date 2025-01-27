long sum (long *val, long i, long j, long n){
    long up, down, left, right, sum;
    up = val[(i-1)*n + j ];
    down = val[(i+1)*n + j ];
    left = val[i*n + j-1];
    right = val[i*n+ j+1];
    sum = up + down + left + right;
    return sum;
}
