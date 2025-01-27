void sum_rows(int* restrict a, int* restrict sum, int n) {
    int i, j;
    for (i = 0; i < n; i++) {
        sum[i] = 0;
        for (j = 0; j < n; j++) {
            sum[i] += *(a + i * n + j);
        }
    }
}