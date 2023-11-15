#include <stdio.h>

long absdiff(long x, long y)
{
    int result;
    if (x <= y) {
        result = y - x;
    } else {
        result = x - y;
    }
    return result;
}

int main()
{
    long x, y;
    printf("x y: ");
    scanf(" %ld %ld", &x, &y);
    printf("absdiff = %ld\n", absdiff(x, y));
}