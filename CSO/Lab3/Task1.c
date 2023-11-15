#include <stdio.h>

long divide(int x, int n)
{
    int r = 0;
    int sign = 1;
    if (x == 0)
        return 0;
    if (x < 0)
    {
        sign *= -1;
        x *= sign;
    }

    long xl = (long) x;
    long nl = (long) n;
    while(xl >= nl)
    {
        xl -= nl;
        r++;
    }
    return ((long) r*sign);
}

int isDiv2n(int x, int n)
{
    int r = divide(x, 1 << n);
    return(x >> n == r);
}

int main()
{
    int x;
    int n;
    printf("x = ");
    scanf(" %d", &x);
    printf("n = ");
    scanf(" %d", &n);
    printf("%d\n", isDiv2n(x,n));
    return (0);
}