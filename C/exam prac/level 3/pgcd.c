#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv)
{
    int i;
    int j;
    int k;
    int max;
    int gcd;

    if (argc == 3)
    {
        i = atoi(argv[1]);
        j = atoi(argv[2]);
        if (i > 0 && j > 0)
        {
            k = 1;
            if (i >= j)
                max = j;
            else
                max = i;
            while (max > 0)
            {
                if (i % k == 0 && j % k == 0)
                    gcd = k;
                k++;
                max--;
            }
            printf("%d", gcd);
        }
    }
    printf("\n");
    return (0);
}