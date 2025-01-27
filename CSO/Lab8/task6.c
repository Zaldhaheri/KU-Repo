void set_row(double *a, double *b, int i, int n,int j)
{
    int op = 0;
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            a[op + j] = b[j];
        }
        op += n;
    }
}

