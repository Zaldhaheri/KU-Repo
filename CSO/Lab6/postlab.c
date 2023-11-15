#include <stdio.h>

int binarycount(int x)
{
    int count = 0;
    int i = 0;
    while (i < 31)
    {
        if ((1 << i) & x)
            count++;
        i++;
    }
    return count;
}

int main()
{
    int x = 0x12345678;
    printf("count = %d\n", binarycount(x));
}